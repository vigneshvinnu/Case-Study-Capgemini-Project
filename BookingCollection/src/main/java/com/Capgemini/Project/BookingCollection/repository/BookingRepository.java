package com.Capgemini.Project.BookingCollection.repository;

import com.Capgemini.Project.BookingCollection.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends MongoRepository<Booking,Integer> {
    List<Booking> findByUserid(String userid);


    Booking findByBookingid(String bookingid);

}
