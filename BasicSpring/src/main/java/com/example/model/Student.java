/**
 * 
 */
package com.example.model;

/**
 * @author acer
 *
 */
public class Student {

	public	int rollno;
	public String name;
	public String add;
	
	public Student(int rollno, String name, String add) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.add = add;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}
	
	
	
}
