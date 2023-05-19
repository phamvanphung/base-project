package com.example.keycloakbase.core;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.keycloakbase.enums.ResponseCode;
import com.example.keycloakbase.exception.InternalException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
@Log4j2
@RequiredArgsConstructor
public class BaseExceptionController {

    private final HttpServletRequest request;

    public static String getTrace(Exception e) {
        try {
            return String.format("%s:%s", e.getStackTrace()[0].getClassName(), e.getStackTrace()[0].getLineNumber());
        } catch (Exception ignored) {
        }
        return ":";
    }

    @ExceptionHandler({InternalException.class})
    public ResponseEntity<?> handleBusinessException(InternalException e) {
        log.error("Business Error: {}, trace: {}", e.getMessage(), getTrace(e));

        return ResponseEntity.ok(new ResponseBase<>(e.getCode(), e.getMessage()));
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<?> handleException(Exception e) {
        log.error("", e);
        return new ResponseEntity<>(new ResponseBase<>(ResponseCode.COMMON_ERROR.getCode(), e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
        MethodArgumentNotValidException.class,
        BindException.class
    })
    public ResponseEntity<?> handleArgumentInvalidException(BindException e) {
        Map<String, List<String>> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, List.of(Optional.ofNullable(errorMessage).orElse("")));
        });

        log.debug("Invalid param: {}", errors);

        ResponseBase<?> responseBase = new ResponseBase<>(errors);
        responseBase.setCode(ResponseCode.INVALID_PARAM.getCode());
        responseBase.setMessage(ResponseCode.INVALID_PARAM.getMessage());

        return new ResponseEntity<>(responseBase, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> handleAccessDeniedException(AccessDeniedException e) {
        return new ResponseEntity<>(
            new ResponseBase<>(
                ResponseCode.ACCESS_DENIED.getCode(),
                ResponseCode.ACCESS_DENIED.getMessage()),
            HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseBase<?> handleConstraintViolationException(ConstraintViolationException e) {
        Map<String, List<String>> errors = new HashMap<>();
        e.getConstraintViolations().forEach((error) -> {
            String fieldName = error.getPropertyPath().toString().replaceFirst("^.+\\.", "");
            String errorMessage = error.getMessage();
            errors.put(fieldName, List.of(Optional.ofNullable(errorMessage).orElse("")));
        });

        ResponseBase<?> responseBase = new ResponseBase<>(errors);
        responseBase.setCode(ResponseCode.INVALID_PARAM.getCode());
        responseBase.setMessage(ResponseCode.INVALID_PARAM.getMessage());

        return responseBase;
    }

    @ExceptionHandler({PropertyReferenceException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseBase<?> handlePropertyReferenceException(PropertyReferenceException e) {
        ResponseBase<?> responseBase = new ResponseBase<>(Map.of(e.getPropertyName(), String.format("Field %s is not accepted", e.getPropertyName())));
        responseBase.setCode(ResponseCode.INVALID_PARAM.getCode());
        responseBase.setMessage(ResponseCode.INVALID_PARAM.getMessage());
        return responseBase;
    }

}
