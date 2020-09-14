package com.example.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.GyanendraJunitIntegrationApplication;
import com.example.entities.Ticket;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GyanendraJunitIntegrationApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TicketBookingControllerIntegrationTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;
	private HttpHeaders headers = new HttpHeaders();

	@Test
	public void testCreateTicket() throws Exception {
		Ticket ticket = new Ticket();
		ticket.setTicketId(1);
		ticket.setPassengerName("Martin Bingel");
		ticket.setSourceStation("Kolkata");
		ticket.setDestStation("Delhi");
//		ticket.setBookingDate(LocalDateTime.now());
		ticket.setEmail("martin.s2017@gmail.com");

		String URIToCreateTicket = "/api/tickets/create";

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
//		ticket.setBookingDate(LocalDateTime.now());
		ticket.setEmail("sean.s2017@gmail.com");

		String inputInJson = this.convertToJson(ticket);

		String URIToCreateTicket = "/api/tickets/create";
		HttpEntity<Ticket> entity = new HttpEntity<Ticket>(ticket, headers);
		testRestTemplate.exchange(completeUri(URIToCreateTicket), HttpMethod.POST, entity, String.class);

		String URI = "/api/tickets/ticketId/2";
		
		
		
		String bodyJsonResponse = testRestTemplate.getForObject(completeUri(URI), String.class);
		assertThat(bodyJsonResponse).isEqualTo(inputInJson);
	}

	@Test
	public void testGetTicketByEmail() throws Exception {

		Ticket ticket = new Ticket();
		ticket.setTicketId(3);
		ticket.setPassengerName("Marry Johnson");
		ticket.setSourceStation("Delhi");
		ticket.setDestStation("Mumbai");
//		ticket.setBookingDate(LocalDateTime.now());
		ticket.setEmail("marrry.j2017@gmail.com");

		String URI = "/api/tickets/create";

		String inputInJson = this.convertToJson(ticket);

		HttpEntity<Ticket> entity = new HttpEntity<Ticket>(ticket, headers);
		testRestTemplate.exchange(completeUri(URI), HttpMethod.POST, entity, String.class);

		String URIToGetTicket = "/api/tickets/email/marrry.j2017@gmail.com";
		String bodyJsonResponse = testRestTemplate.getForObject(completeUri(URIToGetTicket), String.class);
		assertThat(bodyJsonResponse).isEqualTo(inputInJson);

	}

	private String convertToJson(Object object) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(object);
	}

	private String completeUri(String uri) {
		return "http://localhost:" + port + uri;
	}

}
