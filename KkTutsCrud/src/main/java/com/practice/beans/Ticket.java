package com.practice.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ticketid", nullable = false)
	private Integer ticketId;
	
	@Column(name = "pname", nullable = false)
	private String passengerName;
	
	@Column(name = "date", nullable = false)
	private Date date;
	
	@Column(name = "fromst", nullable = false)
	private String fromSt;
	
	@Column(name = "tost", nullable = false)
	private String toSt;

	public Ticket() {
		super();
	}

	public Ticket(Integer ticketId, String passengerName, Date date, String fromSt, String toSt) {
		super();
		this.ticketId = ticketId;
		this.passengerName = passengerName;
		this.date = date;
		this.fromSt = fromSt;
		this.toSt = toSt;
	}

	public Ticket(String passengerName, Date date, String fromSt, String toSt) {
		super();
		this.passengerName = passengerName;
		this.date = date;
		this.fromSt = fromSt;
		this.toSt = toSt;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFromSt() {
		return fromSt;
	}

	public void setFromSt(String fromSt) {
		this.fromSt = fromSt;
	}

	public String getToSt() {
		return toSt;
	}

	public void setToSt(String toSt) {
		this.toSt = toSt;
	}
	
}
