package com.example.keycloakbase.core.crud;

import io.swagger.v3.oas.annotations.Operation;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.keycloakbase.core.BaseResponseData;
import com.example.keycloakbase.core.ResponseBase;
import com.example.keycloakbase.core.crud.dto.GetPageableListRequest;

public interface IRestGetPageableList<T extends GetPageableListRequest, I extends BaseResponseData> {

    @GetMapping("/getPageList")
    @Operation(summary = "Lấy danh sách đối tượng được phân trang", description = "Lấy danh sách đối tượng được phân trang")
    ResponseEntity<ResponseBase<I>> getPageList(@ParameterObject T request);

}
