package com.example.keycloakbase.dto.user.response;

import com.example.keycloakbase.core.BaseResponseData;
import com.example.keycloakbase.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateUserResponse extends BaseResponseData {
    private String id;
    private String name;
    private String email;
    private String username;
    private String phone;

    public CreateUserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.phone = user.getPhone();
    }
}
