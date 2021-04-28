package com.Capgemini.Project.BookingCollection;

import com.Capgemini.Project.BookingCollection.model.Booking;
import com.Capgemini.Project.BookingCollection.model.Passenger;
import com.Capgemini.Project.BookingCollection.service.BookingService;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.Capgemini.Project.BookingCollection.repository.BookingRepository;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.Capgemini.Project.BookingCollection.model.Booking.REFERENCE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class bookingControllertests {

    @Autowired
    private BookingService bookingService;

    @Test
    public void contextLoads() {

    }

    @Test
    @After
    public void Successful()
    {
        System.out.println("Successfully tested");
    }

    @Test
    public void create(){
        List<Passenger> passenger= new ArrayList<>();
        Passenger p1=new Passenger("Vignesh","vinnu",20,"Male");
        Passenger p2=new Passenger("Vadlamuri","vinnu",20,"Male");
        passenger.add(p1);
        passenger.add(p2);
        System.out.println(passenger);
        Booking booking=new Booking();
        booking.setFlightId("AJ6524");
        booking.setPassengerNames(passenger);
        booking.setUserid("kjdbfk");

        bookingService.addBooking(booking);

        System.out.println(booking);

    }

    @Test
    public void create1(){
        List<Passenger> passenger= new ArrayList<>();
        Passenger p1=new Passenger("Vignesh","vinnu",20,"Male");
        Passenger p2=new Passenger("Vadlamuri","vinnu",20,"Male");
        passenger.add(p1);
        passenger.add(p2);
        System.out.println(passenger);
        Booking booking=new Booking();
        booking.setFlightId("AJ6524");
        booking.setPassengerNames(passenger);
        booking.setUserid("ksgadk");

        bookingService.addBooking(booking);

        System.out.println(booking);

    }

    @Test
    public void testFindAll()
    {
        List<Booking> bookings=(List<Booking>) bookingService.getAllBookings();

        for(Booking booking:bookings)
        {
            System.out.println(booking);
        }
        assertThat(bookings).isEqualTo(bookings);
    }





}

