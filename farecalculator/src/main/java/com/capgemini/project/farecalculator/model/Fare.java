package com.capgemini.project.farecalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection= "fares")
public class Fare {

    @Transient
    public static final String REFERENCE = "booking_reference";
    @Id
    private int farenum;
    private int bookingid;
    private double bookingfare;



  }
