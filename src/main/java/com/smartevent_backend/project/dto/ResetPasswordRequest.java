package com.smartevent_backend.project.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ResetPasswordRequest {
    @NotBlank(message="Email is required")
    @Email(message="Email should be valid !")
    private String email;
    @NotBlank(message="Old Password is required")
    private String oldPassword;
    @NotBlank(message="New Password is required")
    @Size(min = 8, max = 20, message = "new password must be 8-20 charactere !")
    private String newPassword;
}
