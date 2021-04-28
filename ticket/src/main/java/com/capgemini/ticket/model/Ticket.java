package com.capgemini.ticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Ticket")
public class Ticket {

  @Transient
  public static final String REFERENCE = "booking_reference";

    @Id
    private int ticketId;
    private int farenum;
    private String flightId;
    private String flightTakeOffStation;
    private String departureDate;
    private String departureTime;
    private String flightLandingStation;
    private String arrivalDate;
    private String arrivalTime;
    private int price;
    private List<Passenger> passengerList;
    private double ticketAmount;

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getFarenum() {
        return farenum;
    }

    public void setFarenum(int farenum) {
        this.farenum = farenum;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getFlightTakeOffStation() {
        return flightTakeOffStation;
    }

    public void setFlightTakeOffStation(String flightTakeOffStation) {
        this.flightTakeOffStation = flightTakeOffStation;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getFlightLandingStation() {
        return flightLandingStation;
    }

    public void setFlightLandingStation(String flightLandingStation) {
        this.flightLandingStation = flightLandingStation;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public double getTicketAmount() {
        return ticketAmount;
    }

    public void setTicketAmount(double ticketAmount) {
        this.ticketAmount = ticketAmount;
    }

}
