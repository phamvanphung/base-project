package com.example.keycloakbase.controller.implController;

import com.example.keycloakbase.controller.IUserController;
import com.example.keycloakbase.core.BaseController;
import com.example.keycloakbase.core.ResponseBase;
import com.example.keycloakbase.dto.user.request.CreateUserRequest;
import com.example.keycloakbase.dto.user.response.CreateUserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends BaseController implements IUserController {
    @Override
    public ResponseEntity<ResponseBase<CreateUserResponse>> create(CreateUserRequest request) {
        return this.execute(request);
    }
}
