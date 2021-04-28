package com.capgemini.ticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fare {
    @Id
    private int farenum;
    private String bookingid;
    private double bookingfare;



   /* private int farenum;
    private double totalbookingFare;
    private int flightFare;
    private int numOfPassengers;
    private int extraLuggage;
    private double gst;
    private double convenienceFee;

    public double getGst() {
        return gst;
    }

    public void setGst(double gst) {
        this.gst = gst;
    }*/
}
