package com.smartevent_backend.project.model;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public class User {

    private String userName;
    private String email;
    private String password;

    private List<Role> role;
    private String resetToken;
    private String resetCode;
    private String status;
    private String profile;
    private String lastName;
    private String firstName;
    private String civilite;
}
