package com.example.keycloakbase.handler.user;

import com.example.keycloakbase.core.RequestHandler;
import com.example.keycloakbase.dto.user.request.CreateUserRequest;
import com.example.keycloakbase.dto.user.response.CreateUserResponse;
import com.example.keycloakbase.entity.User;
import com.example.keycloakbase.enums.ResponseCode;
import com.example.keycloakbase.exception.InternalException;
import com.example.keycloakbase.repository.UserRepository;
import com.example.keycloakbase.utils.HashUtils;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class CreateUserHandler extends RequestHandler<CreateUserRequest, CreateUserResponse> {

    private final UserRepository userRepository;

    @Override
    @SneakyThrows
    public CreateUserResponse handle(CreateUserRequest request) {
        try {
            String hashout = HashUtils.hashSHA256(request.getPassword());
            User user = new User()
                .setEmail(request.getEmail())
                .setName(request.getName())
                .setUsername(request.getUsername())
                .setPhone(request.getPhone())
                .setHash(hashout);
            user = userRepository.save(user);
            return new CreateUserResponse(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalException(ResponseCode.FAILED);
        }
    }
}
