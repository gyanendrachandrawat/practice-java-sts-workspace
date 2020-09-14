package com.ak.boot.model;

public class MyUser {

	@Override
	public String toString() {
		return "MyUser [name=" + name + ", dept=" + dept + "]";
	}

	private String name;
	private String dept;

	public MyUser() {
	}

	public MyUser(String name, String dept) {
		this.name = name;
		this.dept = dept;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

}
