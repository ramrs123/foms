package com.gemini.foms.entity;

import java.time.Instant;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private final String customerName;
    private String customerPhone;
    private final String aadharNumber;
    private String customerEmail;
    private String checkedInRoom;
    private LocalDate dateOfRegister;
    private Instant checkInTime;
    private Instant checkOutTime;

    public Customer(String customerName, String customerPhone, String aadharNumber, String customerEmail, String checkedInRoom, LocalDate dateOfRegister) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.aadharNumber = aadharNumber;
        this.customerEmail = customerEmail;
        this.checkedInRoom = checkedInRoom;
        this.dateOfRegister = LocalDate.now();
    }
    // Executed before customer row is inserted into the table
    private void onCheckIn(){
        checkInTime = Instant.now();
    }

    private void onCheckOut(){
        checkOutTime = Instant.now();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", aadharNumber='" + aadharNumber + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", checkedInRoom='" + checkedInRoom + '\'' +
                ", dateOfRegister=" + dateOfRegister +
                ", checkInTime=" + checkInTime +
                ", checkOutTime=" + checkOutTime +
                '}';
    }
}
