package com.gemini.foms.entity;

import java.time.Instant;

public class Customer {
    private int customerId;
    private final String customerName;
    private String customerPhone;
    private final String aadharNumber;
    private String customerEmail;
    private String checkedInRoom;

    private Instant checkInTime;
    private Instant checkOutTime;

    public Customer(String customerName, String customerPhone, String aadharNumber, String customerEmail, String checkedInRoom) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.aadharNumber = aadharNumber;
        this.customerEmail = customerEmail;
        this.checkedInRoom = checkedInRoom;
    }
    // Executed before customer row is inserted into the table
    private void onCheckIn(){
        checkInTime = Instant.now();
    }

    private void onCheckOut(){
        checkOutTime = Instant.now();
    }

}
