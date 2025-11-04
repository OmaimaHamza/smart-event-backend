package com.smartevent_backend.project.controller;

import com.smartevent_backend.project.dto.RoleDto;
import com.smartevent_backend.project.service.RoleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
@Validated
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<?> getAllRoles(){
        return ResponseEntity.status(200).body(roleService.getRoles());
    }
    @PostMapping
    public ResponseEntity<?> addRole(@Valid @RequestBody RoleDto roleDto){
        return ResponseEntity.status(201).body(roleService.addRole(roleDto));
    }
    @DeleteMapping
    public ResponseEntity<?> deleteAll(){
        roleService.deleteAll();
        return ResponseEntity.ok("all roles are deleted");
    }
    @GetMapping("/{roleName}")
    public ResponseEntity<?> getRole(@Valid @PathVariable String roleName){
        return ResponseEntity.status(200).body(roleService.getRole(roleName));
    }
}
