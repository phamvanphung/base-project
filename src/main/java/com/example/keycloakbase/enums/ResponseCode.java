package com.example.keycloakbase.enums;

public enum ResponseCode {
    // Common
    SUCCESS(0, "Success"),
    FAILED(1, "Failed"),
    COMMON_ERROR(2, "Common Error"),
    INVALID_PARAM(3, "Invalid param"),
    INVALID_SESSION(4, "Invalid session"),
    UNHANDLED_REQUEST(5, "Unhandled request"),
    REQUEST_WAS_EXPIRED(6, "Request was expired"),
    SECURITY_VIOLATION(7, "Security violation"),
    RESPONSE_BODY_NOT_FOUND(8, "Response body not found"),
    RESPONSE_ENCRYPTING_FAILED(9, "Response encrypting failed"),
    ACCESS_DENIED(10, "Access denied"),
    INVALID_REFRESH_TOKEN(11, "Invalid refresh token"),
    THIRD_PARTY_API_ERROR(12, "Third party api error"),
    REQUEST_PENDING(13, "Request is pending"),
    CLIENT_NOT_FOUND(14, "Not Found"),
    ACCESS_TOKEN_NOT_FOUND(15, "Access token not found"),
    NOT_FOUND(16, "Item not found"),
    AUTHORIZATION_FAILED(17, "Authorization fail"),
    SYSTEM_ERROR(18, "System error"),
    INVALID_STATUS(19, "Invalid status"),
    NOT_PERMISSION(20, "Not permission"),


    // AUTH
    INVALID_USERNAME_OR_PASSWORD(101, "username or password wrong"),
    REFRESH_TOKEN_INVALID(102, "Refresh token invalid"),


    ;


    private final int code;
    private final String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
