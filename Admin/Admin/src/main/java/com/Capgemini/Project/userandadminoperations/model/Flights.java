package com.Capgemini.Project.userandadminoperations.model;

import com.sun.istack.internal.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Getter
@Setter
@Document(collection="flightsDetails")
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


    public Flights(String flightId, String flightTakeOffStation, String departureDate, String departureTime, String flightLandingStation, String arrivalDate, String arrivalTime, int price) {
        this.flightId = flightId;
        this.flightTakeOffStation = flightTakeOffStation;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.flightLandingStation = flightLandingStation;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.price = price;
    }
}

