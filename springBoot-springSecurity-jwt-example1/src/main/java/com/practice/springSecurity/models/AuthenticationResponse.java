package com.practice.springSecurity.models;

public class AuthenticationResponse {
	
	private final String jwt;

	/**
	 * @return the jwt
	 */
	public String getJwt() {
		return jwt;
	}

	/**
	 * @param jwt
	 */
	public AuthenticationResponse(String jwt) {
		super();
		this.jwt = jwt;
	}
	

}
