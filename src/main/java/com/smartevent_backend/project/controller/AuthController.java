package com.smartevent_backend.project.controller;

import com.smartevent_backend.project.dto.LoginRequest;
import com.smartevent_backend.project.dto.RegisterRequest;
import com.smartevent_backend.project.dto.UserDto;
import com.smartevent_backend.project.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Validated
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest user){
        UserDto newUser=userService.register(user);
        return ResponseEntity.status(201).body(newUser);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest){
        UserDto dto=userService.login(loginRequest);
        return ResponseEntity.status(200).body(dto);
    }
}
