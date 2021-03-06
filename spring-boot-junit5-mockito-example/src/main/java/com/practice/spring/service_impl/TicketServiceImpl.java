package com.practice.spring.service_impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.spring.model.Ticket;
import com.practice.spring.repository.TicketRepo;
import com.practice.spring.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private TicketRepo ticketRepo;

	@Override
	public Ticket createTicket(Ticket ticket) {
		return ticketRepo.save(ticket);
	}

	@Override
	public Ticket getTicketById(Integer ticketId) {
		return ticketRepo.getOne(ticketId);
	}

	@Override
	public Iterable<Ticket> getAllBookedTickets() {
		return ticketRepo.findAll();
	}

	@Override
	public Ticket getTicketByEmail(String email) {
		return ticketRepo.findByEmail(email);
	}

	@Override
	public Boolean deleteTicket(Integer ticketId) {
		Ticket ticket = ticketRepo.getOne(ticketId);
		ticketRepo.delete(ticket);
		return ticketRepo.existsById(ticketId);
	}

	@Override
	public Ticket updateTicket(Integer ticketId, String newEmail) {
		Ticket ticket = ticketRepo.getOne(ticketId);
		ticket.setEmail(newEmail);
		ticketRepo.save(ticket);
		return ticketRepo.findByEmail(newEmail);
	}

}
