package com.example.keycloakbase.core;

public interface Handler<T extends RequestData, I extends ResponseData> {
    I handle(T request);
}
