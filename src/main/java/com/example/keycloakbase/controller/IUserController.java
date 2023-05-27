package com.example.keycloakbase.controller;

import com.example.keycloakbase.core.crud.IRestCreate;
import com.example.keycloakbase.dto.user.request.CreateUserRequest;
import com.example.keycloakbase.dto.user.response.CreateUserResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "User controller")
@RequestMapping(value = "/api/user")
public interface IUserController extends IRestCreate<CreateUserRequest, CreateUserResponse> {

}
