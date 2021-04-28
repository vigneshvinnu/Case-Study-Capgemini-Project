package com.capgemini.project.farecalculator.service;


import com.capgemini.project.farecalculator.exception.NotFoundException;
import com.capgemini.project.farecalculator.model.Booking;
import com.capgemini.project.farecalculator.model.Fare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.project.farecalculator.repository.Farerepository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.capgemini.project.farecalculator.model.Fare.REFERENCE;


@Service
    public class Fareservice {
    @Autowired
    Farerepository fareRepository;

    @Autowired
    private RestTemplate template;

    @Autowired
    private ReferenceNumberGenerator referenceNumberGenerator;

    public Object saveOrUpdate(Fare fare)
    {
        double gst = 0.18;
        double conveniencefee = 0.2;
        int bid = fare.getBookingid();
        Booking booking = template.getForObject("http://Booking-service/book/getBooking/"+bid, Booking.class);
        System.out.println(booking);
        int numOfPassengers = booking.getPassengerNames().size();
        double amount = booking.getBookingAmount();
        double bookingfares = (amount + amount * conveniencefee + amount * gst) * numOfPassengers;
        fare.setBookingfare(bookingfares);
        fare.setFarenum(referenceNumberGenerator.getReferenceNumber(REFERENCE));
        return fareRepository.save(fare);
    }
    public List<Fare> getAll()
    {
        List<Fare> list = fareRepository.findAll();
        if(list.isEmpty())
            throw new NotFoundException("No Flights Available");
        return list;
    }

    public Optional<Fare> getByFarenum(int farenum){
        Optional<Fare> list = fareRepository.findById(farenum);
        if(!list.isPresent())
            throw new NotFoundException("Fare with the Farenum "+ farenum + " doesnot exist");
        return list;
    }





}

