package com.smartevent_backend.project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//role : for example ADMIN , USER,...
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Role {
    @Id
    @Column(nullable = false, unique = true, length = 30)
    private String roleId;
    @Column(nullable = false, unique = true, length = 50)
    private String name;

    // one role can have multiple user
    @OneToMany(mappedBy = "role")
    private List<User> users;

    // one role can have multiple rights & each right can be associated to multiple roles
    @ManyToMany
    @JoinTable(
            name = "role_rights",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "right_id")
    )
    private List<Right> rights;


}
