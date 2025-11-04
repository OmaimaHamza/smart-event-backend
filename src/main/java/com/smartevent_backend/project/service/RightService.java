package com.smartevent_backend.project.service;

import com.smartevent_backend.project.model.Right;

import java.util.List;

public interface RightService {
    public Right addRight(String rightName);
    public Right getRight(String rightName);
    public List<Right> getRights();
    public void deleteRight(String rightName);
}
