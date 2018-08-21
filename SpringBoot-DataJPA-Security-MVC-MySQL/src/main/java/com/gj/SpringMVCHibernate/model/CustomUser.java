package com.gj.SpringMVCHibernate.model;

import java.util.Arrays;

public class CustomUser {

	private long id;
	
	private String username;

	private String password;
	
	private boolean enabled;
	
	
	private CustomAuthories[] authorities;
	
	private String authority; //comma separated

	
	public CustomUser(){
		
	}
	
	public CustomUser(long id, String username, String password, boolean enabled,String authority) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authority = authority;
		populateAuthorites(authority);
	}

	private void populateAuthorites(String authority2) {
		if(authority2!=null){
			String [] temp=authority2.split(",");
			authorities=new CustomAuthories[temp.length];
			for(int i=0;i<temp.length;i++){
				authorities[i]=new CustomAuthories(temp[i]);
			}
		}
		
	}

	public CustomAuthories[] getAuthorities() {
		return authorities;
	}

	public void setAuthorities(CustomAuthories[] authorities) {
		this.authorities = authorities;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}



	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
		if(authority!=null)
			populateAuthorites(authority);
	}

	@Override
	public String toString() {
		return "CustomUser [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
				+ ", authorities=" + Arrays.toString(authorities) + ", authority=" + authority + "]";
	}
	
	
//	
	
}
