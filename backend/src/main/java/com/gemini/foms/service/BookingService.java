package com.gemini.foms.service;

import com.gemini.foms.entity.Booking;
import com.gemini.foms.entity.Customer;
import com.gemini.foms.entity.Room;
import com.gemini.foms.repository.BookingRepository;
import com.gemini.foms.repository.CustomerRepository;
import com.gemini.foms.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private RoomRepository roomRepo;

    @Autowired
    private CustomerRepository customerRepo;

    // CHECK-IN
    public Booking checkIn(Long customerId) {

        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Room room = roomRepo.findByAvailableTrue()
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No rooms available"));

        room.setAvailable(false);
        roomRepo.save(room);

        Booking booking = new Booking();
        booking.setCustomerId(customer.getId());
        booking.setRoomId(room.getId());
        booking.setCheckInDate(java.time.LocalDate.now().toString());
        booking.setStatus("CHECKED_IN");

        return bookingRepo.save(booking);
    }

    // CHECK-OUT
    public Booking checkOut(Long bookingId) {

        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        Room room = roomRepo.findById(booking.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        room.setAvailable(true);
        roomRepo.save(room);

        booking.setStatus("CHECKED_OUT");
        booking.setCheckOutDate(java.time.LocalDate.now().toString());

        return bookingRepo.save(booking);
    }

    public List<Booking> getAll() {
        return bookingRepo.findAll();
    }
}
