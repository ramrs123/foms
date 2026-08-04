package com.gemini.foms.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Name is required")
    @Size(min=2,max=50)
    @Pattern(regexp="^[A-Za-z ]+$",
            message="Name should contain only alphabets")
    private String name;

    @NotBlank(message="Phone is required")
    @Pattern(regexp="^[6-9]\\d{9}$",
            message="Invalid phone number")
    @Column(unique=true)
    private String phone;




    // getters/setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}