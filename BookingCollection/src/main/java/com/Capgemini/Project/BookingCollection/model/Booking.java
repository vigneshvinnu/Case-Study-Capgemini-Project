package com.Capgemini.Project.BookingCollection.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Booking")
public class Booking {

    @Transient
    public static final String REFERENCE = "booking_reference";
    @Id
    private int bookingid;
    private List<Passenger> passengerNames;
    private String userid;
    private String flightId;
    private double bookingAmount=0;

}
