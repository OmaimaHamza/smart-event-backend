package com.smartevent_backend.project.serviceImpl;

import com.smartevent_backend.project.dto.LoginRequest;
import com.smartevent_backend.project.dto.RegisterRequest;
import com.smartevent_backend.project.dto.UserDto;
import com.smartevent_backend.project.exception.InvalideCredentials;
import com.smartevent_backend.project.exception.UserAlreadyExist;
import com.smartevent_backend.project.exception.UserNotFound;
import com.smartevent_backend.project.model.User;
import com.smartevent_backend.project.repository.UserRepository;
import com.smartevent_backend.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public List<UserDto> getUsers(){
        List<UserDto> dtos=new ArrayList<>();
        List<User> users=userRepository.findAll();
        for(User user:users){
            dtos.add(convertToDto(user));
        }
        if(dtos.isEmpty()) throw new UserNotFound("No user found");
        return dtos;
    }
    public UserDto register(RegisterRequest user){
        if(!userRepository.existsByEmail(user.getEmail())){
            if(!user.getPassword().equals(user.getConfirmPassword())) {
                throw new RuntimeException("Passwords do not match");
            }
            User newUser= new User();
            newUser.setEmail(user.getEmail());
            newUser.setProfile(user.getProfile());
            newUser.setLastName(user.getLastName());
            newUser.setUsername(user.getUsername());
            newUser.setFirstName(user.getFirstName());
            newUser.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(newUser);
            return convertToDto(newUser);
        }
        else throw new UserAlreadyExist("user already exist with the specified email");
    }
    public UserDto login(LoginRequest loginRequest){
        User correctUser = userRepository.findByEmail(loginRequest.getEmail());
        if (correctUser == null) {
            throw new UserNotFound("No user with the specified email");
        }
        if (!passwordEncoder.matches(loginRequest.getPassword(), correctUser.getPassword())) {
            throw new InvalideCredentials("Password is incorrect");
        }
        return convertToDto(correctUser);


    }
    public UserDto convertToDto(User user){
        UserDto userDto = new UserDto();

        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole());
        userDto.setProfile(user.getProfile());
        userDto.setLastName(user.getLastName());
        userDto.setFirstName(user.getFirstName());
        userDto.setStatus(user.getStatus());
        userDto.setUsername(user.getUsername());
        return userDto;
    }
}
