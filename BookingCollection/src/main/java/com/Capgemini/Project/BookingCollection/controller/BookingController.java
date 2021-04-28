package com.Capgemini.Project.BookingCollection.controller;

import com.Capgemini.Project.BookingCollection.model.Booking;
import com.Capgemini.Project.BookingCollection.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/book")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @GetMapping("/getBookingsByUserId/{userid}")
    public ResponseEntity<List<Booking>> getBookingsByUserId(@PathVariable String userid) {
        return ResponseEntity.ok(bookingService.getBookingsByUserId(userid));

    }

    // Getting REST GET request and returning 'Booking List' from BookingCollection
    @GetMapping("/allBookings")
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());

    }

    // Getting REST GET request and returning 'Booking Object/ Optional' from
    // BookingCollection
    @GetMapping("/getBooking/{bookingId}")
    public ResponseEntity<Optional<Booking>> getBooking(@PathVariable int bookingId) {
        return ResponseEntity.ok(bookingService.getBooking(bookingId));
    }

    // Getting REST POST request and returning 'String/Void' from BookingCollection
    @PostMapping("/addBooking")
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
        return ResponseEntity.ok(bookingService.addBooking(booking));
    }

    // Getting REST PUT request and returning 'String/Void' from BookingCollection
    @PutMapping("/updateBooking/{bookingid}")
    public ResponseEntity<String> updateBooking(@RequestBody Booking booking, @PathVariable int bookingid) {
        return ResponseEntity.ok(bookingService.updateBooking(booking, bookingid));
    }

    // Getting REST DELETE request and returning 'String/Void' from BookingCollection
    @DeleteMapping("/deleteBooking/{bookingId}")
    public ResponseEntity<String> deleteBooking(@PathVariable int bookingId) {
        return ResponseEntity.ok(bookingService.deleteBooking(bookingId));
    }



    /*@GetMapping("/booking")
    private Object getRegistrationsList(@RequestBody Booking booking)
    {
        return bookingService.getBookingsList();
    }

    @PostMapping("/booking")
    public TransactionResponse saveUserDetails(@RequestBody TransactionRequest request)
    {
            return bookingService.saveOrUpdate(request);
    }*/
}
