package com.example.keycloakbase.core.crud;

import com.example.keycloakbase.core.BaseResponseData;
import com.example.keycloakbase.core.ResponseBase;
import com.example.keycloakbase.core.crud.dto.DeleteRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface IRestDelete<T extends DeleteRequest, I extends BaseResponseData> {

    @DeleteMapping("/v1/delete/{id}")
    @Operation(summary = "Xoá đối tượng", description = "Xoá đối tượng")
    ResponseEntity<ResponseBase<I>> delete(@PathVariable String id);

}
