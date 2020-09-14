package com.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.entity.Student;
import com.practice.repository.BooksRepo;
import com.practice.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@Autowired
	private BooksRepo booksRepo;

	public List<Student> getAllStudent() {
		return studentRepo.findAll();
	}

	public Student updateStudent(Integer sid, Student student) {
		Student student1 = studentRepo.findById(sid).orElse(null);
		student1.setScontact(student.getScontact());
		return studentRepo.save(student1);
	}

	public Student getOneStudent(Integer sid) {
		Student student = studentRepo.findById(sid).get();
		return null;
	}

	public Student deleteStudent(Integer sid) {
		Student student = studentRepo.findById(sid).orElse(null);
		studentRepo.delete(student);
		return student;
	}

	public Student createStudent(Student student) {
//		Student newstudent=new Student();
//		newstudent.setSid(student.getSid());
//		newstudent.setSname(student.getSname());
//		newstudent.setScontact(student.getScontact());
//		newstudent.setScity(student.getScity());
//		Books books=booksRepo.getOne(bid);
//		List<Books> l=new ArrayList<>();
//		l.add(books);
//		newstudent.setBooks(l);
		return studentRepo.save(student);
	}

}
