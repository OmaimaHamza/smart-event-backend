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
    private String password;
    @NotBlank(message="Confirm password is required")
    private String confirmPassword;

    private String profile;

    public @NotBlank(message = "Username is required") @Size(min = 5, max = 20, message = "Username must be 5-20 charactere !") String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank(message = "Username is required") @Size(min = 5, max = 20, message = "Username must be 5-20 charactere !") String username) {
        this.username = username;
    }

    public @NotBlank(message = "First Name is required") @Size(min = 5, max = 20, message = "First Name must be 5-20 charactere !") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank(message = "First Name is required") @Size(min = 5, max = 20, message = "First Name must be 5-20 charactere !") String firstName) {
        this.firstName = firstName;
    }

    public @Size(min = 5, max = 20, message = "Last Name must be 5-20 charactere !") String getLastName() {
        return lastName;
    }

    public void setLastName(@Size(min = 5, max = 20, message = "Last Name must be 5-20 charactere !") String lastName) {
        this.lastName = lastName;
    }

    public @NotBlank(message = "Email is required") @Email(message = "Email should be valid !") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Email is required") @Email(message = "Email should be valid !") String email) {
        this.email = email;
    }

    public @NotBlank(message = "password is required") @Size(min = 8, max = 20, message = "password must be 8-20 charactere !") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "password is required") @Size(min = 8, max = 20, message = "password must be 8-20 charactere !") String password) {
        this.password = password;
    }

    public @NotBlank(message = "Confirm password is required") String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(@NotBlank(message = "Confirm password is required") String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
