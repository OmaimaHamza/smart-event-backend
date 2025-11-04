package com.smartevent_backend.project.exception;

public class FieldAlreadyExist extends RuntimeException {
    public FieldAlreadyExist(String message) {
        super(message);
    }
}
