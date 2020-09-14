package com.practice.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@Column(name = "sid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sid;
	
	@Column(name = "sname")
	private String sname;
	
	@Column(name = "scontact")
	private String scontact;
	
	@Column(name = "scity")
	private String scity;
	
	
	@OneToMany(fetch = FetchType.EAGER, targetEntity = Books.class, cascade = CascadeType.MERGE)
	@JoinColumn(name = "sid", referencedColumnName = "sid")
	private List<Books> books=new ArrayList<>();

	/**
	 * @return the sid
	 */
	public Integer getSid() {
		return sid;
	}


	/**
	 * @param sid the sid to set
	 */
	public void setSid(Integer sid) {
		this.sid = sid;
	}


	/**
	 * @return the sname
	 */
	public String getSname() {
		return sname;
	}


	/**
	 * @param sname the sname to set
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}


	/**
	 * @return the scontact
	 */
	public String getScontact() {
		return scontact;
	}


	/**
	 * @param scontact the scontact to set
	 */
	public void setScontact(String scontact) {
		this.scontact = scontact;
	}


	/**
	 * @return the scity
	 */
	public String getScity() {
		return scity;
	}


	/**
	 * @param scity the scity to set
	 */
	public void setScity(String scity) {
		this.scity = scity;
	}


	/**
	 * @return the books
	 */
	public List<Books> getBooks() {
		return books;
	}


	/**
	 * @param books the books to set
	 */
	public void setBooks(List<Books> books) {
		this.books = books;
	}
	
}
