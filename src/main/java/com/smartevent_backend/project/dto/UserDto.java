package com.smartevent_backend.project.dto;

import com.smartevent_backend.project.model.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private String username;
    private String email;

    private Role role;

    private String status;
    private String profile;
    private String lastName;
    private String firstName;

}
