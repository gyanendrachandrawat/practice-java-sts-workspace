package com.practice.spring.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.practice.spring.model.Ticket;
import com.practice.spring.repository.TicketRepo;

@SpringBootTest
public class TicketServiceTest {
	
	@Autowired
	private TicketRepo ticketRepo;
	
	@Autowired
	private TicketService ticketBookingService;
	
	@Test
	public void testCreateTicket() {
		Ticket ticket=this.getTicket1();
		Mockito.when(ticketRepo.save(ticket)).thenReturn(ticket);
		assertEquals(ticket, ticketBookingService.createTicket(ticket));
	}

	@Test
	public void testGetTicketById() {
		Ticket ticket=this.getTicket1();
		Mockito.when(ticketRepo.getOne(1)).thenReturn(ticket);
		assertThat(ticketBookingService.getTicketById(1)).isEqualTo(ticket);
	}
	
	@Test
	public void testGetAllBookedTickets() {
		Ticket ticket1=this.getTicket1();
		Ticket ticket2=this.getTicket2();
		
		List<Ticket> ticketList=new ArrayList<>();
		ticketList.add(ticket1);
		ticketList.add(ticket2);
		
		Mockito.when(ticketRepo.findAll()).thenReturn(ticketList);
		assertEquals(ticketList, ticketBookingService.getAllBookedTickets());
	}
	
	// Temporary Ticket Objects
		private Ticket getTicket1() {
			Ticket ticket=new Ticket();
			ticket.setTicketId(1);
			ticket.setPassengerName("Sean Murphy");
			ticket.setSourceStation("Delhi");
			ticket.setDestStation("Mumbai");
			ticket.setBookingDate(LocalDate.now());
			ticket.setEmail("sean.s2006@gmail.com");
			return ticket;
		}
		
		private Ticket getTicket2() {
			Ticket ticket=new Ticket();
			ticket.setTicketId(2);
			ticket.setPassengerName("gyanendra");
			ticket.setSourceStation("pithampur");
			ticket.setDestStation("indore");
			ticket.setBookingDate(LocalDate.now());
			ticket.setEmail("gyanendra@email.com");
			return ticket;
		}

}
