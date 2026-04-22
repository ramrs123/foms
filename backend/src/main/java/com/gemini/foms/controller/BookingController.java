package com.gemini.foms.controller;

import com.gemini.foms.entity.Booking;
import com.gemini.foms.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingService service;

    @PostMapping("/checkin/{customerId}")
    public Booking checkIn(@PathVariable Long customerId) {
        return service.checkIn(customerId);
    }

    @PostMapping("/checkout/{bookingId}")
    public Booking checkOut(@PathVariable Long bookingId) {
        return service.checkOut(bookingId);
    }

    @GetMapping
    public List<Booking> getAll() {
        return service.getAll();
    }
}
