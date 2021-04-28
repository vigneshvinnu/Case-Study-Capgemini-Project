package com.capgemini.project.farecalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Booking {

    @Id
    private int bookingid;
    private List<Passenger> passengerNames;
    private String userid;
    private String flightId;
    private double bookingAmount=0;

}
