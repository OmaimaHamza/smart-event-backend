package com.smartevent_backend.project.service;

import com.smartevent_backend.project.dto.RoleDto;
import com.smartevent_backend.project.model.Role;

import java.util.List;

public interface RoleService {
    public Role addRole(RoleDto role);
    public Role getRole(String roleName);
    public List<Role> getRoles();
    public void deleteRole(String roleName);
    public void deleteAll();
}
