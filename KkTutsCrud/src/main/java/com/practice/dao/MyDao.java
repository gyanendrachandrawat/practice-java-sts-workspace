package com.practice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.beans.Ticket;

@Repository
public interface MyDao extends CrudRepository<Ticket, Integer> {
	
}
