package com.practice.spring.service;

import com.practice.spring.model.Ticket;

public interface TicketService {

	Ticket createTicket(Ticket ticket);

	Ticket getTicketById(Integer ticketId);

	Iterable<Ticket> getAllBookedTickets();

	Ticket getTicketByEmail(String email);

	Boolean deleteTicket(Integer ticketId);

	Ticket updateTicket(Integer ticketId, String newEmail);

}
