package com.gemini.foms.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="bookings")
public class Booking{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Room room;

    private LocalDateTime checkInTime;

    private LocalDateTime checkOutTime;

    private boolean active=true;

    public Long getBookingId() {
        return bookingId;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public LocalDateTime getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(LocalDateTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
