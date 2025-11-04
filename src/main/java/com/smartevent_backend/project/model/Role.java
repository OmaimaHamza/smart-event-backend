package com.smartevent_backend.project.model;

import jakarta.persistence.*;

import java.util.List;

//role : for example ADMIN , USER,...
@Entity
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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Right> getRights() {
        return rights;
    }

    public void setRights(List<Right> rights) {
        this.rights = rights;
    }
}
