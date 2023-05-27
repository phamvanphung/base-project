package com.example.keycloakbase.core.crud;

import com.example.keycloakbase.core.BaseResponseData;
import com.example.keycloakbase.core.ResponseBase;
import com.example.keycloakbase.core.crud.dto.UpdateRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface IRestUpdate<T extends UpdateRequest, I extends BaseResponseData> {

    @PutMapping("/v1/update")
    @Operation(summary = "Cập nhật đối tượng", description = "Cập nhật đối tượng")
    ResponseEntity<ResponseBase<I>> update(@Valid @RequestBody T request);

}
