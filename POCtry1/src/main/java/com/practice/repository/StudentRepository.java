package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.beans.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByEmailAndPassword(String email, String password);

}
