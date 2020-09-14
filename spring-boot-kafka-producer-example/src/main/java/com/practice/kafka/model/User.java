package com.practice.kafka.model;

public class User {
	
	private Integer id;
	
	private String name;
	
	private String department;

	/**
	 * 
	 */
	public User() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param department
	 */
	public User(Integer id, String name, String department) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", department=" + department + "]";
	}
	
}