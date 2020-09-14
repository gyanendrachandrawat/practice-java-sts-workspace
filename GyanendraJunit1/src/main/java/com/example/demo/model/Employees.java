package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Employees {
	
	private  List<Employee> employeeList;

	/**
	 * @return the employeeList
	 */
	public List<Employee> getEmployeeList() {
		if (employeeList==null) {
			employeeList=new ArrayList<>();
		}
		return employeeList;
	}

	/**
	 * @param employeeList the employeeList to set
	 */
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
	
	
}
