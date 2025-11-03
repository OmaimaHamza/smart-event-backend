package com.smartevent_backend.project.model;

import java.util.List;

//role : for example ADMIN , USER,...
public class Role {
    private String _id;
    private String name;
    private List<Right> rights;
}
