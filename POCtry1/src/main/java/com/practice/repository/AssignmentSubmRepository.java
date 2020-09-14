package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.beans.AssignmentSubm;

@Repository
public interface AssignmentSubmRepository extends JpaRepository<AssignmentSubm, Integer> {
	
}
