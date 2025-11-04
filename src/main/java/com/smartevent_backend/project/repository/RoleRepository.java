package com.smartevent_backend.project.repository;

import com.smartevent_backend.project.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,String> {
}
