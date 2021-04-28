package com.Capgemini.Project.BookingCollection.service;



import com.Capgemini.Project.BookingCollection.exception.NotFoundException;
import com.Capgemini.Project.BookingCollection.model.Booking;
import com.Capgemini.Project.BookingCollection.model.Flights;
import com.Capgemini.Project.BookingCollection.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.Capgemini.Project.BookingCollection.model.Booking.REFERENCE;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    private RestTemplate template;

    @Autowired
    private ReferenceNumberGenerator referenceNumberGenerator;

    public Booking addBooking(Booking booking) {
        String fn=booking.getFlightId();
        System.out.println(fn);
        Flights flight= template.getForObject("http://Admin-User-Operations/admin/flights/"+fn, Flights.class);
        booking.setBookingAmount(flight.getPrice());
        booking.setBookingid(referenceNumberGenerator.getReferenceNumber(REFERENCE));

        return  bookingRepository.save(booking);

    }

    public List<Booking> getBookingsList()
    {
        List<Booking> bookings = new ArrayList<Booking>();
        bookingRepository.findAll().forEach(bookingsList -> bookings.add(bookingsList));
        if(bookings.isEmpty()) {
            throw new NotFoundException("No Bookings Available");
        }
        return bookings;
    }



    public String updateBooking(Booking booking, int bookingid) {
        Optional<Booking> list=bookingRepository.findById(bookingid);
        System.out.println(list);
        if(!list.isPresent())
            throw new NotFoundException("Booking with the id "+ bookingid + "not exist");
        bookingRepository.deleteById(bookingid);
        bookingRepository.save(booking);
        return "Booking Updated with: " + booking.getBookingid();
    }

    public String deleteBooking(int bookingid) {
        if (bookingRepository.existsById(bookingid)) {
            bookingRepository.deleteById(bookingid);
            return "Booking Deleted with booking Id : "+ bookingid;
        } else {
            throw new NotFoundException("Booking with Id "+bookingid+" not exist");
        }
    }

    public Optional<Booking> getBooking(int bookingId) {
        Optional<Booking> booking = bookingRepository.findById(bookingId);
        if (!booking.isPresent()) {
            throw new NotFoundException("No Booking available with bookingId : " + bookingId);
        }
        return booking;
    }

    public List<Booking> getAllBookings() {
        List<Booking> allBookingList = bookingRepository.findAll();
        if (allBookingList.isEmpty()) {
            throw new NotFoundException("No Booking available");
        }
        return allBookingList;
    }

    public List<Booking> getBookingsByUserId(String userid) {
        List<Booking> bookingList = bookingRepository.findByUserid(userid);
        if (bookingList.isEmpty()) {
            throw new NotFoundException("No Booking available with userId : " + userid);
        }
        return bookingList;
    }




}
