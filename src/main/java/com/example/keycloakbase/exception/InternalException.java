package com.example.keycloakbase.exception;


import com.example.keycloakbase.enums.ResponseCode;

public class InternalException extends RuntimeException {

    private final String message;
    private final Integer code;
    private ResponseCode responseCode;

    public InternalException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.message = responseCode.getMessage();
        this.code = responseCode.getCode();
        this.responseCode = responseCode;
    }

    public InternalException(String message, Integer code) {
        super(message);
        this.message = message;
        this.code = code;
    }

    public ResponseCode getResponseCode() {
        return this.responseCode;
    }

    public String getMessage() {
        return this.message == null ? "unknown" : this.message;
    }

    public int getCode() {
        return this.code == null ? 1 : this.code;
    }

}
