package com.gemini.foms.entity;

import java.math.BigInteger;
import java.time.Instant;

public class Customer {
    private int customerId;
    private final String customerName;
    private String customerPhone;
    private final String aadharNumber;
    private String customerEmail;
    private String roomNo;

    private Instant checkInTime;
    private Instant checkOutTime;

    public Customer(String customerName, String customerPhone, String aadharNumber, String customerEmail, String roomNo) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.aadharNumber = aadharNumber;
        this.customerEmail = customerEmail;
        this.roomNo = roomNo;
    }

    private void onCheckIn(){
        checkInTime = Instant.now();
    }
}
