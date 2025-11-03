package com.smartevent_backend.project.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterRequest {
    @NotBlank(message="Username is required")
    @Size(min = 5, max = 20, message = "Username must be 5-20 charactere !")
    private String username;
    @NotBlank(message="First Name is required")
    @Size(min = 5, max = 20, message = "First Name must be 5-20 charactere !")
    private String firstName;
    @Size(min = 5, max = 20, message = "Last Name must be 5-20 charactere !")
    private String lastName;
    @NotBlank(message="Email is required")
    @Email(message="Email should be valid !")
    private String email;
    @NotBlank(message="password is required")
    @Size(min = 8, max = 20, message = "password must be 8-20 charactere !")
    private String password;
    @NotBlank(message="Confirm password is required")
    private String confirmPassword;

    private String profile;
}
