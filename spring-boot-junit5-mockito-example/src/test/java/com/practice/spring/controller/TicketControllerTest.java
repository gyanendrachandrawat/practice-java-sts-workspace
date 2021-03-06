package com.practice.spring.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.spring.SpringBootJunit5MockitoExampleApplication;
import com.practice.spring.model.Ticket;

@SpringBootTest(classes = SpringBootJunit5MockitoExampleApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TicketControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private HttpHeaders headers = new HttpHeaders();

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void testCreateTicket() throws Exception {
		Ticket ticket = new Ticket();
		ticket.setTicketId(1);
		ticket.setPassengerName("Martin Bingel");
		ticket.setSourceStation("Kolkata");
		ticket.setDestStation("Delhi");
		ticket.setBookingDate(LocalDate.now());
		ticket.setEmail("martin.s2017@gmail.com");

		String URIToCreateTicket = "/create";

		String inputInJson = this.convertToJson(ticket);

		HttpEntity<Ticket> entity = new HttpEntity<Ticket>(ticket, headers);
		ResponseEntity<String> response = testRestTemplate.exchange(completeUri(URIToCreateTicket), HttpMethod.POST,
				entity, String.class);

		String responseInJson = response.getBody();
		assertThat(responseInJson).isEqualTo(inputInJson);
	}

	@Test
	public void testGetTicketById() throws Exception {

		Ticket ticket = new Ticket();
		ticket.setTicketId(2);
		ticket.setPassengerName("Sean Murphy");
		ticket.setSourceStation("Kolkata");
		ticket.setDestStation("Mumbai");
		ticket.setBookingDate(LocalDate.now());
		ticket.setEmail("sean.s2017@gmail.com");

		String inputInJson = this.convertToJson(ticket);

		String URIToCreateTicket = "/api/tickets/create";
		HttpEntity<Ticket> entity = new HttpEntity<Ticket>(ticket, headers);
		testRestTemplate.exchange(completeUri(URIToCreateTicket), HttpMethod.POST, entity, String.class);

		String URI = "/ticketId/2";
		
		String bodyJsonResponse = testRestTemplate.getForObject(completeUri(URI), String.class);
		assertThat(bodyJsonResponse).isEqualTo(inputInJson);
	}
	
	

	private String convertToJson(Object object) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(object);
	}

	private String completeUri(String uri) {
		return "http://localhost:" + port + uri;
	}

}
