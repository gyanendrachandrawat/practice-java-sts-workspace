package com.practice.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.spring.model.Ticket;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {

	Ticket findByEmail(String email);
	
}
