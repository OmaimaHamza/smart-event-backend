package com.smartevent_backend.project.dto;

import com.smartevent_backend.project.model.Right;
import com.smartevent_backend.project.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class RoleDto {
    @NotBlank(message = "Name is required")
    private String name;
    private List<User> users;
    private List<Right> rights;

}
