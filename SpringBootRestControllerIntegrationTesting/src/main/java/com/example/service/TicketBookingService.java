package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.TicketBookingDao;
import com.example.entities.Ticket;

@Service
public class TicketBookingService {
	
	@Autowired
	private TicketBookingDao  ticketBookingDao;

	public Ticket createTicket(Ticket ticket) {
		return ticketBookingDao.save(ticket);
	}

	public Ticket getTicketById(Integer ticketId) {
		return ticketBookingDao.getOne(ticketId);
	}

	public Iterable<Ticket> getAllBookedTickets() {
		return ticketBookingDao.findAll();
	}

	public Ticket getTicketByEmail(String email) {
		return ticketBookingDao.findByEmail(email);
	}

	public Ticket updateTicket(Integer ticketId, String newEmail) {
		Ticket tempTicket=ticketBookingDao.getOne(ticketId);
		tempTicket.setEmail(newEmail);
		return ticketBookingDao.save(tempTicket);
	}

	public Boolean deleteTicket(Integer ticketId) {
		ticketBookingDao.deleteById(ticketId);
		return ticketBookingDao.existsById(ticketId);
	}
	
}
