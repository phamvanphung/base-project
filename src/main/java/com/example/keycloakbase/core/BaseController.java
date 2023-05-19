package com.example.keycloakbase.core;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import com.example.keycloakbase.enums.ResponseCode;
import com.example.keycloakbase.exception.InternalException;

public class BaseController {

    @Autowired
    protected SpringBus springBus;

    protected <T extends BaseRequestData, I extends ResponseData> ResponseEntity<ResponseBase<I>> execute(T request) {
        String subjectId = getCurrentSubjectId();
        if (subjectId != null && !subjectId.equals("anonymous")) {
            request.setSubjectId(getCurrentSubjectId());
        }
        return ResponseEntity.ok(new ResponseBase<>(this.springBus.execute(request)));
    }

    protected String getCurrentSubjectId() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if (securityContext == null ||
            securityContext.getAuthentication() == null ||
            StringUtils.isBlank(securityContext.getAuthentication().getName())) {
            throw new InternalException(ResponseCode.AUTHORIZATION_FAILED);
        }
        return securityContext.getAuthentication().getName();
    }

//    protected ResponseEntity<ResponseBase<String>> buildResponse(PackedMessage packedMessage) {
//        //Set header
//        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.set(HeaderBase.CLIENT, packedMessage.getClientId());
//        responseHeaders.set(HeaderBase.TIMESTAMP, String.valueOf(packedMessage.getTimestamp()));
//        responseHeaders.set(HeaderBase.SIGNATURE, packedMessage.getSignature());
//        return ResponseEntity.ok()
//                .headers(responseHeaders)
//                .body(new ResponseBase<>(packedMessage.getEncryptedData()));
//    }
}
