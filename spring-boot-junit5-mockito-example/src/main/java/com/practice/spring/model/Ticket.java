package com.practice.spring.model;

import java.time.LocalDate;

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
	@Column(name = "ticket_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ticketId;

	@Column(name = "passenger_name", nullable = false)
	private String passengerName;

	@Column(name = "booking_date")
	private LocalDate bookingDate;

	@Column(name = "source_station", nullable = false)
	private String sourceStation;

	@Column(name = "dest_station", nullable = false)
	private String destStation;

	@Column(name = "email", nullable = false)
	private String email;

	/**
	 * 
	 */
	public Ticket() {
		super();
	}

	/**
	 * @param ticketId
	 * @param passengerName
	 * @param bookingDate
	 * @param sourceStation
	 * @param destStation
	 * @param email
	 */
	public Ticket(Integer ticketId, String passengerName, LocalDate bookingDate, String sourceStation,
			String destStation, String email) {
		super();
		this.ticketId = ticketId;
		this.passengerName = passengerName;
		this.bookingDate = bookingDate;
		this.sourceStation = sourceStation;
		this.destStation = destStation;
		this.email = email;
	}

	/**
	 * @return the ticketId
	 */
	public Integer getTicketId() {
		return ticketId;
	}

	/**
	 * @param ticketId the ticketId to set
	 */
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	/**
	 * @return the passengerName
	 */
	public String getPassengerName() {
		return passengerName;
	}

	/**
	 * @param passengerName the passengerName to set
	 */
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	/**
	 * @return the sourceStation
	 */
	public String getSourceStation() {
		return sourceStation;
	}

	/**
	 * @param sourceStation the sourceStation to set
	 */
	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}

	/**
	 * @return the destStation
	 */
	public String getDestStation() {
		return destStation;
	}

	/**
	 * @param destStation the destStation to set
	 */
	public void setDestStation(String destStation) {
		this.destStation = destStation;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the bookingDate
	 */
	public LocalDate getBookingDate() {
		return bookingDate;
	}

	/**
	 * @param bookingDate the bookingDate to set
	 */
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", passengerName=" + passengerName + ", bookingDate=" + bookingDate
				+ ", sourceStation=" + sourceStation + ", destStation=" + destStation + ", email=" + email + "]";
	}


}
