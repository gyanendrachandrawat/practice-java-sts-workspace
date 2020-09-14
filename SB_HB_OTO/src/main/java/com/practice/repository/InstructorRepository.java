package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.beans.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {

}
