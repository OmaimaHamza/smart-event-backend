package com.smartevent_backend.project.model;

import jakarta.persistence.*;

import java.util.List;

//Rights: for example READ_USERS, CREATE_USERS
@Entity
@Table(name = "rights")
public class Right {
    @Id
    @Column(nullable = false, unique = true, length = 30)
    private String rightId;
    @Column(unique = true, length = 30)
    private String name;
    @Column(unique = true, length = 30)
    private String groupName;
    @ManyToMany(mappedBy = "rights")
    private List<Role> role;

    public String getRightId() {
        return rightId;
    }

    public void setRightId(String rightId) {
        this.rightId = rightId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Role> getRole() {
        return role;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }
}
