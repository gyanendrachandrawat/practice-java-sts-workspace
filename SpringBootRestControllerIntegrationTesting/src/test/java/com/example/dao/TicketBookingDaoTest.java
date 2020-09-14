package com.example.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entities.Ticket;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TicketBookingDaoTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private TicketBookingDao ticketBookingDao;
	
	@Before
	public void beforeMessage() {
		System.out.println("tests start : ");
	}
	
	@Test
	public void testSaveTicket() {
		Ticket ticket=this.getTicket1();
		Ticket saved=entityManager.persist(ticket);
		Ticket retrive=ticketBookingDao.findById(saved.getTicketId()).orElse(null);
		assertEquals(saved, retrive);
	}
	
	@Test
	public void testGetTicketById() {
		Ticket ticket=this.getTicket1();
		Ticket saved=entityManager.persist(ticket);
		Ticket retrive=ticketBookingDao.findById(saved.getTicketId()).orElse(null);
		assertEquals(saved, retrive);
	}
	
	@Test
	public void testGetAllBookedTickets() {
		Ticket ticket1=this.getTicket1();
		Ticket ticket2=this.getTicket2();
		entityManager.persist(ticket1);
		entityManager.persist(ticket2);
		Iterable<Ticket> allTicketsFromDb = ticketBookingDao.findAll();
		List<Ticket> ticketList = new ArrayList<>();
		
		for (Ticket ticket : allTicketsFromDb) {
			ticketList.add(ticket);
		}
		assertThat(ticketList.size()).isEqualTo(2);
	}
	
	@Test
	public void testFindByEmail() {
		Ticket ticket=this.getTicket1();
		entityManager.persist(ticket);
		Ticket retrive=ticketBookingDao.findByEmail("sean.s2006@gmail.com");
		assertEquals("Sean Murphy", retrive.getPassengerName());
	}
	
	@Test
//	@Ignore
	public void testDeleteTicketById() {
		Ticket ticket=this.getTicket1();
		Ticket saved=entityManager.persist(ticket);
		entityManager.remove(saved);
		assertEquals(false, ticketBookingDao.existsById(1));
	}
	
	@Test
	public void testUpdateTicket() {
		Ticket ticket=this.getTicket1();
		entityManager.persist(ticket);
		Ticket retrive=ticketBookingDao.findByEmail(ticket.getEmail());
		retrive.setEmail("newEmail@email.com");
		entityManager.persist(retrive);
		assertEquals("newEmail@email.com", retrive.getEmail());
	}
	
	
	
	
	
	// Temporary Ticket Objects
	private Ticket getTicket1() {
		Ticket ticket=new Ticket();
		ticket.setPassengerName("Sean Murphy");
		ticket.setSourceStation("Delhi");
		ticket.setDestStation("Mumbai");
		ticket.setBookingDate(LocalDateTime.now());
		ticket.setEmail("sean.s2006@gmail.com");
		return ticket;
	}
	
	private Ticket getTicket2() {
		Ticket ticket=new Ticket();
		ticket.setPassengerName("gyanendra");
		ticket.setSourceStation("pithampur");
		ticket.setDestStation("indore");
		ticket.setBookingDate(LocalDateTime.now());
		ticket.setEmail("gyanendra@email.com");
		return ticket;
	}
	
}
