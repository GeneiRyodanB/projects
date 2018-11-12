package com.zerohunger.geneiryodan.feedapp.models.users;

import java.util.List;


public class Role {

	public final static String BENEVOLE = "BENEVOLE";
	public final static String COORDINATEUR = "COORDINATEUR";
	public final static String ADMIN = "ADMIN";

    private Long id;

	private String role;

	private List<User> users;
	
	public Role(String role) {
		this.role =role;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
		
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
