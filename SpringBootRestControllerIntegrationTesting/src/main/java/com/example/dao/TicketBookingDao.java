package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Ticket;

@Repository
public interface TicketBookingDao extends JpaRepository<Ticket, Integer> {

	Ticket findByEmail(String email);
	
}
