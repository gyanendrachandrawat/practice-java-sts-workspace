package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.beans.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

	Teacher findByEmailAndPassword(String email, String password);
	
}
