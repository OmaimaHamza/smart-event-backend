package com.smartevent_backend.project.service;

import com.smartevent_backend.project.dto.LoginRequest;
import com.smartevent_backend.project.dto.RegisterRequest;
import com.smartevent_backend.project.dto.UserDto;
import com.smartevent_backend.project.exception.InvalideCredentials;
import com.smartevent_backend.project.exception.UserAlreadyExist;
import com.smartevent_backend.project.exception.UserNotFound;
import com.smartevent_backend.project.model.User;
import com.smartevent_backend.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    public UserDto register(RegisterRequest user);
    public UserDto login(LoginRequest loginRequest);
    public List<User> getUsers();

}
