package com.gemini.foms.entity;

import com.gemini.foms.entity.enums.appointment.AppointmentStatus;
import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentId;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    private LocalDate appointmentDate;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User staffAssigned;

    private Instant appointmentBookedAt;
    @Enumerated(EnumType.STRING)
    private AppointmentStatus appointmentStatus;
    private String remarks;

    protected Appointment() {
    };

    public Appointment(Customer customer, User staffAssigned, AppointmentStatus appoointmentStatus) {
        this.customer = customer;
        this.staffAssigned = staffAssigned;
        this.appointmentStatus = AppointmentStatus.CREATED;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        LocalDate today = LocalDate.now();
        if (appointmentDate.isAfter(today)) {
            this.appointmentDate = appointmentDate;
        } else {
            throw new RuntimeException("Can only book on a date from tomorrow");
        }
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setStaffAssigned(User staffAssigned) {
        this.staffAssigned = staffAssigned;
    }

    public User getStaffAssigned() {
        return staffAssigned;
    }

    public void setAppointmentBookedAt(Instant appointmentBookedAt) {
        this.appointmentBookedAt = Instant.now();
    }

    public Instant getAppointmentBookedAt() {
        return appointmentBookedAt;
    }

    public void confirmBooking() {
        if (appointmentStatus == AppointmentStatus.CREATED) {
            appointmentStatus = AppointmentStatus.BOOKED;
        } else {
            throw new IllegalStateException("Create the booking first");
        }
    }

    public void rescheduleBooking(LocalDate rescheduledDate){
        setAppointmentDate(appointmentDate);
    }

    public void cancelBooking() {

        if (appointmentStatus == AppointmentStatus.BOOKED ) {
            appointmentStatus = AppointmentStatus.CANCELLED;
        } else {
            throw new IllegalStateException("Cannot cancel it");
        }
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", customer=" + customer +
                ", appointmentDate=" + appointmentDate +
                ", staffAssigned=" + staffAssigned +
                ", appointmentBookedAt=" + appointmentBookedAt +
                ", appointmentStatus=" + appointmentStatus +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
