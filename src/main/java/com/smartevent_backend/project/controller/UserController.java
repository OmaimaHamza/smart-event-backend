package com.smartevent_backend.project.controller;

import com.smartevent_backend.project.dto.LoginRequest;
import com.smartevent_backend.project.dto.RegisterRequest;
import com.smartevent_backend.project.dto.UserDto;
import com.smartevent_backend.project.model.User;
import com.smartevent_backend.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest user){
        UserDto newUser=userService.register(user);
        return ResponseEntity.status(201).body(newUser);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        UserDto dto=userService.login(loginRequest);
        return ResponseEntity.status(200).body(dto);
    }
}
