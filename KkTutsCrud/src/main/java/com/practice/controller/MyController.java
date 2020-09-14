package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.beans.Ticket;
import com.practice.service.MyService;

@RestController
@RequestMapping(value = "/tickets")
public class MyController {
	
	@Autowired
	private MyService myService;
	
	@RequestMapping(value = "/home")
	public String home() {
		return "home.html";
	}
	
	@PostMapping(value = "/createticket")
	public Ticket createTicket(@RequestBody Ticket ticket) {
		return myService.createTicket(ticket);
	}
	
	@GetMapping(value = "/ticket/{ticketid}")
	public Ticket getTicketById(@PathVariable("ticketid")Integer ticketid) {
		return myService.getTicketById(ticketid);
	}
	
	@GetMapping(value = "/ticket/all")
	public Iterable<Ticket> getAllTicket() {
		return myService.getAllTicket();
	}
	
	@DeleteMapping(value = "/delete/{ticketid}")
	public void deleteTicket(@PathVariable("ticketid")Integer ticketid) {
		myService.deleteTicket(ticketid);
	}
	
	@PutMapping(value = "/update/{ticketid}/{newtost:.+}")
	public Ticket updateTicket(@PathVariable("ticketid")Integer ticketid, @PathVariable("newtost")String newtost) {
		return myService.updateTicket(ticketid, newtost);
	}
	
}
