package com.gemini.foms.repository;


import com.gemini.foms.entity.Appointment;
import com.gemini.foms.entity.enums.appointment.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    /*
     * Fetching appointments using customer name so that we know which customer has which appointments
     */
    @Query(value = "SELECT * FROM Appointments WHERE customerName = :name", nativeQuery = true)
    List<Appointment> findAppointmentsByCustomerName(@Param("name") String customerName);

    /*
     * Fetching appointments using appointmentDate so that we know which appointments are on which date
     */
    @Query(value = "SELECT * FROM Appointments WHERE appointmentDate = :date", nativeQuery = true)
    List<Appointment> findAppointmentsByAppointmentDate(@Param("date") LocalDate date);

    /*
     * Fetching appointments using appointmentStatus so that we know which appointments are on which state like pending ,
     *  completed so that we can keep track on appointments that are in pending state
     */
    @Query(value = "SELECT * FROM Appointments WHERE appointmentStatus = :status", nativeQuery = true)
    List<Appointment> findAppointmentsByAppointmentStatus(@Param("status") AppointmentStatus status);
}
