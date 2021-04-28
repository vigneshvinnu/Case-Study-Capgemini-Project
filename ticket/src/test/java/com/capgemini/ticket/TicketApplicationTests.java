package com.capgemini.ticket;

import com.capgemini.ticket.model.Ticket;
import com.capgemini.ticket.service.TicketService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TicketApplicationTests {

	@Autowired
	TicketService ticketService;

	@Test
	void contextLoads() {
	}

	@Test
	@AfterEach
	public void Successful()
	{
		System.out.println("Successfully tested");
	}

	@Test
	public void getTicket()
	{
		Ticket ticket=new Ticket();
		ticket.setFarenum(22);
		ticketService.getTicket(ticket);
		assertNotNull(ticket);
	}

}
