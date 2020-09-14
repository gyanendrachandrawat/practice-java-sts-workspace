package com.practice.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.spring.model.Ticket;
import com.practice.spring.service.TicketService;

@RestController
public class TicketController {

	@Autowired
	private TicketService ticketService;
	
	@GetMapping(value = "/testGetCall")
	public ResponseEntity<String> testGetCall(){
		return new ResponseEntity<String>("Hello this is get call", HttpStatus.OK);
	}
	
	@PostMapping(value = "/testCall")
	public ResponseEntity<String> testCall(@RequestBody String message) {
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@PostMapping(value = "/create")
	public Ticket createTicket(@RequestBody Ticket ticket) {
		return ticketService.createTicket(ticket);
	}

	@GetMapping(value = "/ticketId/{ticketId}")
	public Ticket getTicketById(@PathVariable("ticketId") Integer ticketId) {
		return ticketService.getTicketById(ticketId);
	}

	@GetMapping(value = "/alltickets")
	public Iterable<Ticket> getAllBookedTickets() {
		return ticketService.getAllBookedTickets();
	}

	@GetMapping(value = "/email/{email:.+}")
	public Ticket getTicketByEmail(@PathVariable("email") String email) {
		return ticketService.getTicketByEmail(email);
	}

	@DeleteMapping(value = "/ticketId/{ticketId}")
	public Boolean deleteTicket(@PathVariable("ticketId") Integer ticketId) {
		return ticketService.deleteTicket(ticketId);
	}

	@PutMapping(value = "/ticketId/{ticketId}/email/{newEmail:.+}")
	public Ticket updateTicket(@PathVariable("ticketId") Integer ticketId, @PathVariable("newEmail") String newEmail) {
		return ticketService.updateTicket(ticketId, newEmail);
	}

}
