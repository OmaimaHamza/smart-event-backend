package com.smartevent_backend.project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

//Rights: for example READ_USERS, CREATE_USERS
@Entity
@Table(name = "rights")
@Getter
@Setter
@NoArgsConstructor
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


}
