package com.smartevent_backend.project.serviceImpl;

import com.smartevent_backend.project.dto.RoleDto;
import com.smartevent_backend.project.exception.FieldAlreadyExist;
import com.smartevent_backend.project.exception.FieldNotFound;
import com.smartevent_backend.project.model.Role;
import com.smartevent_backend.project.repository.RoleRepository;
import com.smartevent_backend.project.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role addRole(RoleDto roleDto) {
        if(roleRepository.existsById(roleDto.getName()))
            throw new FieldAlreadyExist("role: "+roleDto.getName()+" is already exist");
        else{
            Role role=new Role();
            role.setRoleId(roleDto.getName());
            role.setName(roleDto.getName());
            role.setUsers(roleDto.getUsers());
            role.setRights(roleDto.getRights());
            roleRepository.save(role);
            return role;
        }
    }
    @Override
    public Role getRole(String roleName) {
        return roleRepository.findById(roleName).orElseThrow(() -> new FieldNotFound("no role with the specified name"));
    }

    @Override
    public List<Role> getRoles() {
        if(roleRepository.findAll().isEmpty()) throw new FieldNotFound("No role found");
        return roleRepository.findAll();
    }

    @Override
    public void deleteRole(String roleName) {
        if(roleRepository.existsById(roleName)){
            roleRepository.deleteById(roleName);
        }else throw new FieldNotFound("No role with the specified name");
    }

    @Override
    public void deleteAll() {
        roleRepository.deleteAll();
    }
}
