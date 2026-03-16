package com.gemini.foms.entity;

import com.gemini.foms.entity.enums.user.Role;

public class User {
    private int userId;
    private String employeeId;
    private String employeeName;
    private Role role;

    protected User(){}

    public User(String employeeId, String employeeName, Role role){
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }


    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
