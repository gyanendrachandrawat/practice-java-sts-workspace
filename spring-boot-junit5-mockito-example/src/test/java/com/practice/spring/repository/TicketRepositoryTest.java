package com.practice.spring.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.practice.spring.model.Ticket;

@DataJpaTest
public class TicketRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private TicketRepo ticketRepo;
	
	@Test
	public void testSaveTicket() {
		Ticket ticket=this.getTicket1();
		Ticket saved=entityManager.persist(ticket);
		Ticket retrive=ticketRepo.findById(saved.getTicketId()).orElse(null);
		assertEquals(saved, retrive);
	}

	@Test
	public void testGetTicketById() {
		Ticket ticket = this.getTicket1();
		Ticket saved = entityManager.persist(ticket);
		Ticket retrive = ticketRepo.findById(saved.getTicketId()).orElse(null);
		assertEquals(saved, retrive);
	}
	
	@Test
	public void testGetAllBookedTickets() {
		Ticket ticket1=this.getTicket1();
		Ticket ticket2=this.getTicket2();
		entityManager.persist(ticket1);
		entityManager.persist(ticket2);
		Iterable<Ticket> allTicketsFromDb = ticketRepo.findAll();
		List<Ticket> ticketList = new ArrayList<>();
		
		for (Ticket ticket : allTicketsFromDb) {
			ticketList.add(ticket);
		}
		assertThat(ticketList.size()).isEqualTo(2);
	}

	// Temporary Ticket Objects
	private Ticket getTicket1() {
		Ticket ticket = new Ticket();
		ticket.setPassengerName("Sean Murphy");
		ticket.setSourceStation("Delhi");
		ticket.setDestStation("Mumbai");
		ticket.setBookingDate(LocalDate.now());
		ticket.setEmail("sean.s2006@gmail.com");
		return ticket;
	}

	private Ticket getTicket2() {
		Ticket ticket = new Ticket();
		ticket.setPassengerName("gyanendra");
		ticket.setSourceStation("pithampur");
		ticket.setDestStation("indore");
		ticket.setBookingDate(LocalDate.now());
		ticket.setEmail("gyanendra@email.com");
		return ticket;
	}

}
