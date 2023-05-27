package com.example.keycloakbase.core.crud;

import com.example.keycloakbase.core.BaseResponseData;
import com.example.keycloakbase.core.ResponseBase;
import com.example.keycloakbase.core.crud.dto.GetPageableListRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface IRestGetPageableList<T extends GetPageableListRequest, I extends BaseResponseData> {

    @GetMapping("/v1/getPageList")
    @Operation(summary = "Lấy danh sách đối tượng được phân trang", description = "Lấy danh sách đối tượng được phân trang")
    ResponseEntity<ResponseBase<I>> getPageList(@ParameterObject T request);

}
