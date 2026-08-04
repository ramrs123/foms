package com.gemini.foms.service;

import com.gemini.foms.entity.Booking;
import com.gemini.foms.entity.Customer;
import com.gemini.foms.entity.Room;
import com.gemini.foms.exception.CheckoutNotAllowedException;
import com.gemini.foms.repository.BookingRepository;
import com.gemini.foms.repository.CustomerRepository;
import com.gemini.foms.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepo;
    private final RoomRepository roomRepo;
    private final CustomerRepository customerRepo;

    public BookingService(BookingRepository bookingRepo,
                          RoomRepository roomRepo,
                          CustomerRepository customerRepo) {
        this.bookingRepo = bookingRepo;
        this.roomRepo = roomRepo;
        this.customerRepo = customerRepo;
    }

    //CHECK-IN
    @Transactional
    public Booking checkIn(Long customerId) {

        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        if (bookingRepo.existsByCustomerIdAndActiveTrue(customerId)) {
            throw new RuntimeException("Customer is already checked in.");
        }

        Room room = roomRepo.findFirstByAvailableTrueOrderByRoomNoAsc()
                .orElseThrow(() -> new RuntimeException("No rooms available"));

        room.setAvailable(false);

        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setRoom(room);
        booking.setCheckInTime(LocalDateTime.now());
        booking.setActive(true);

        roomRepo.save(room);

        return bookingRepo.save(booking);
    }

    // CHECK-OUT
    @Transactional
    public Booking checkOut(Long bookingId) {

        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        if(!booking.isActive()){

            throw new CheckoutNotAllowedException(
                    "Customer already checked out.");

        }

        Room room = booking.getRoom();

        room.setAvailable(true);
        booking.setActive(false);

        booking.setCheckOutTime(
                LocalDateTime.now());

        roomRepo.save(room);

        return bookingRepo.save(booking);
    }

    public List<Booking> getAll() {
        return bookingRepo.findAll();
    }
}
