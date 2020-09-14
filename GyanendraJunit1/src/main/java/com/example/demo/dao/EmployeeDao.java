package com.example.demo.dao;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;
import com.example.demo.model.Employees;

@Repository
public class EmployeeDao {
	
	private static Employees list = new Employees();
	
	static {
		list.getEmployeeList().add(new Employee(1, "emp1f", "emp1l", "emp1@email.com"));
		list.getEmployeeList().add(new Employee(2, "emp2f", "emp2l", "emp2@email.com"));
		list.getEmployeeList().add(new Employee(3, "emp3f", "emp3l", "emp3@email.com"));
	}

	public Employees getAllEmployees() {
		return list;
	}

	public void addEmployee(Employee employee) {
		list.getEmployeeList().add(employee);
	}
	
}
