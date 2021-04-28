package com.capgemini.ticket.service;

import com.capgemini.ticket.model.Booking;
import com.capgemini.ticket.model.Fare;
import com.capgemini.ticket.model.Flights;
import com.capgemini.ticket.model.Ticket;
import com.capgemini.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static com.capgemini.ticket.model.Ticket.REFERENCE;

@Service
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    private RestTemplate template;

    @Autowired
    private ReferenceNumberGenerator referenceNumberGenerator;

    public Object getTicket(Ticket ticket)
    {
        int farenumber = ticket.getFarenum();
        Fare fare = template.getForObject("http://Fare-Calculator/fare/fare/"+farenumber, Fare.class);
        System.out.println(fare);
        double amount = fare.getBookingfare();

        String bid = fare.getBookingid();
        Booking booking = template.getForObject("http://Booking-service/book/getBooking/"+bid, Booking.class);
        System.out.println(booking);

        String fn = booking.getFlightId();
        Flights flight= template.getForObject("http://Admin-User-Operations/admin/flights/"+fn, Flights.class);
        System.out.println(flight);

        ticket.setTicketId(referenceNumberGenerator.getReferenceNumber(REFERENCE));
        ticket.setFlightId(flight.getFlightId());
        ticket.setFlightTakeOffStation(flight.getFlightTakeOffStation());
        ticket.setFlightLandingStation(flight.getFlightLandingStation());
        ticket.setDepartureDate(flight.getDepartureDate());
        ticket.setDepartureTime(flight.getDepartureTime());
        ticket.setArrivalDate(flight.getArrivalDate());
        ticket.setArrivalTime(flight.getArrivalTime());
        ticket.setPrice(flight.getPrice());
        ticket.setPassengerList(booking.getPassengerNames());
        ticket.setTicketAmount(amount);

        return ticketRepository.save(ticket);
    }

}
