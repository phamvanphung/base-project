package com.example.keycloakbase.core.crud;

import com.example.keycloakbase.core.BaseResponseData;
import com.example.keycloakbase.core.ResponseBase;
import com.example.keycloakbase.core.crud.dto.CreateRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface IRestCreate<T extends CreateRequest, I extends BaseResponseData> {

    @PostMapping("/v1/create")
    @Operation(summary = "Tạo đối tượng", description = "Tạo đối tượng")
    ResponseEntity<ResponseBase<I>> create(@Valid @RequestBody T request);

}
