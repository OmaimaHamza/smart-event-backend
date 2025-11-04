package com.smartevent_backend.project.repository;

import com.smartevent_backend.project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findByEmail(String email);
    User findByUsername(String username);
    Boolean existsByEmail(String email);


}
