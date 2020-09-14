package com.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.beans.Ticket;
import com.practice.dao.MyDao;

@Service
public class MyService {
	
	@Autowired
	private MyDao myDao;
	
	public Ticket createTicket(Ticket ticket) {
		return myDao.save(ticket);
	}

	public Ticket getTicketById(Integer ticketid) {
		return myDao.findById(ticketid).orElse(null);
	}

	public Iterable<Ticket> getAllTicket() {
		return myDao.findAll();
	}

	public void deleteTicket(Integer ticketid) {
		myDao.deleteById(ticketid);
	}

	public Ticket updateTicket(Integer ticketid, String newtost) {
		Ticket tempTicket=myDao.findById(ticketid).orElse(null);
		tempTicket.setToSt(newtost);
		Ticket newTicket=myDao.save(tempTicket);
		return newTicket;
	}

	
	
}
