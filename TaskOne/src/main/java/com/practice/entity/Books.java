package com.practice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Books {
	
	@Id
	@Column(name = "bid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bid;
	
	@Column(name = "bname")
	private String bname;
	
	/**
	 * @return the bid
	 */
	public Integer getBid() {
		return bid;
	}

	/**
	 * @param bid the bid to set
	 */
	public void setBid(Integer bid) {
		this.bid = bid;
	}

	/**
	 * @return the bname
	 */
	public String getBname() {
		return bname;
	}

	/**
	 * @param bname the bname to set
	 */
	public void setBname(String bname) {
		this.bname = bname;
	}
	
}
