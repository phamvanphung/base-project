package com.example.keycloakbase.core.crud;

import io.swagger.v3.oas.annotations.Operation;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.keycloakbase.core.BaseResponseData;
import com.example.keycloakbase.core.ResponseBase;
import com.example.keycloakbase.core.crud.dto.GetListRequest;

import javax.validation.Valid;

public interface IRestGetList<T extends GetListRequest, I extends BaseResponseData> {

    @GetMapping("/getList")
    @Operation(summary = "Lấy danh sách đối tượng", description = "Lấy danh sách đối tượng")
    ResponseEntity<ResponseBase<I>> getList(@Valid @ParameterObject T request);

}
