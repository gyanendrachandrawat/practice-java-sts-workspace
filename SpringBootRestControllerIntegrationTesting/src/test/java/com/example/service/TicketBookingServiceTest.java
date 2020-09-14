package com.example.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.dao.TicketBookingDao;
import com.example.entities.Ticket;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TicketBookingServiceTest {
	
	@Autowired
	private TicketBookingService ticketBookingService;
	
	@MockBean
	private TicketBookingDao ticketBookingDao;
	
	@Test
	public void testCreateTicket() {
		Ticket ticket=this.getTicket1();
		Mockito.when(ticketBookingDao.save(ticket)).thenReturn(ticket);
		assertEquals(ticket, ticketBookingService.createTicket(ticket));
	}

	@Test
	public void testGetTicketById() {
		Ticket ticket=this.getTicket1();
		Mockito.when(ticketBookingDao.getOne(1)).thenReturn(ticket);
		assertThat(ticketBookingService.getTicketById(1)).isEqualTo(ticket);
	}
	
	@Test
	public void testGetAllBookedTickets() {
		Ticket ticket1=this.getTicket1();
		Ticket ticket2=this.getTicket2();
		
		List<Ticket> ticketList=new ArrayList<>();
		ticketList.add(ticket1);
		ticketList.add(ticket2);
		
		Mockito.when(ticketBookingDao.findAll()).thenReturn(ticketList);
		assertEquals(ticketList, ticketBookingService.getAllBookedTickets());
	}
	
	@Test
	public void testDeleteTicket() {
		Mockito.when(ticketBookingDao.existsById(1)).thenReturn(false);
		assertEquals(false, ticketBookingService.deleteTicket(1));
	}
	
	@Test
	public void testUpdateTicket() {
		Ticket ticket=this.getTicket1();
		Mockito.when(ticketBookingDao.getOne(1)).thenReturn(ticket);
		ticket.setEmail("newEmail@email.com");
		Mockito.when(ticketBookingDao.save(ticket)).thenReturn(ticket);
		assertEquals(ticket,ticketBookingService.updateTicket(1, "newEmail@email.com"));
	}
	
	@Test
	public void testGetTicketByEmail() {
		Ticket ticket=this.getTicket1();
		Mockito.when(ticketBookingDao.findByEmail("sean.s2006@gmail.com")).thenReturn(ticket);
		assertEquals(ticket, ticketBookingService.getTicketByEmail("sean.s2006@gmail.com"));
	}
	
	
	
	
	// Temporary Ticket Objects
	private Ticket getTicket1() {
		Ticket ticket=new Ticket();
		ticket.setTicketId(1);
		ticket.setPassengerName("Sean Murphy");
		ticket.setSourceStation("Delhi");
		ticket.setDestStation("Mumbai");
		ticket.setBookingDate(LocalDateTime.now());
		ticket.setEmail("sean.s2006@gmail.com");
		return ticket;
	}
	
	private Ticket getTicket2() {
		Ticket ticket=new Ticket();
		ticket.setTicketId(2);
		ticket.setPassengerName("gyanendra");
		ticket.setSourceStation("pithampur");
		ticket.setDestStation("indore");
		ticket.setBookingDate(LocalDateTime.now());
		ticket.setEmail("gyanendra@email.com");
		return ticket;
	}
	
}
