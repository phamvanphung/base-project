package com.example.keycloakbase.core.crud;

import com.example.keycloakbase.core.BaseResponseData;
import com.example.keycloakbase.core.ResponseBase;
import com.example.keycloakbase.core.crud.dto.GetDetailRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface IRestGetDetail<T extends GetDetailRequest, I extends BaseResponseData> {

    @GetMapping("/v1/getDetail/{id}")
    @Operation(summary = "Lấy chi tiết đối tượng", description = "Lấy chi tiết đối tượng")
    ResponseEntity<ResponseBase<I>> getDetail(@PathVariable String id);

}
