package com.gj.spring.model;

import org.springframework.security.core.GrantedAuthority;

public class CustomAuthories implements GrantedAuthority {

	String auth;
	public CustomAuthories(String auth){
		this.auth=auth;
	}
	@Override
	public String getAuthority() {
	
		return this.auth;
	}

}
