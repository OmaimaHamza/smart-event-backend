package com.smartevent_backend.project.exception;

public class FieldNotFound extends RuntimeException {
    public FieldNotFound(String message) {
        super(message);
    }
}
