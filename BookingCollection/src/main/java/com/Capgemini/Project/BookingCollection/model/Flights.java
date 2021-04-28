package com.Capgemini.Project.BookingCollection.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;


@Getter
@Setter
@ToString
public class Flights {
    @Id
    private String flightId;
    private String flightTakeOffStation;
    @NotNull
    //@JsonFormat(pattern="MM-dd-YYYY HH:mm a")
    private String departureDate;

    private String departureTime;
    @NotNull
    private String flightLandingStation;
    //@JsonFormat(pattern="MM-dd-YYYY HH:mm a")
    private String arrivalDate;
    private String arrivalTime;
    @NotNull
    private int price;



}

