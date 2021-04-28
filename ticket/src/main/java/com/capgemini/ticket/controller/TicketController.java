package com.capgemini.ticket.controller;

import com.capgemini.ticket.model.Ticket;
import com.capgemini.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class TicketController {



    @Autowired
    TicketService ticketService;

    @GetMapping("/ticket")
    public Object getTicketEstimator(Ticket ticket)
    {
        return ticketService.getTicket(ticket);
    }
}
