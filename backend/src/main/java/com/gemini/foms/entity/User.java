package com.gemini.foms.entity;

import com.gemini.foms.entity.enums.user.Role;
import com.gemini.foms.utils.PasswordHasher;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String employeeId;
    private String password;
    private String employeeName;
    private Role role;
    private boolean isActive = false;

    protected User(){}

    public User(String employeeId,String password,  String employeeName, Role role){
        this.employeeId = employeeId;
        this.password = PasswordHasher.hashedPassword(password);
        this.employeeName = employeeName;
        this.role = role;
        isActive = true;
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
