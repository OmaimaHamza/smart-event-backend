package com.smartevent_backend.project.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
    @NotBlank(message="Email is required")
    @Email(message="Email should be valid !")
    private String email;
    @NotBlank(message="Password is required")
    private String password;
}
