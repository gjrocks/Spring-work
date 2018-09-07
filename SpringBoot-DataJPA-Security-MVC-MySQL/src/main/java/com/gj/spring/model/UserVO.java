package com.gj.spring.model;

import java.util.Date;

public class UserVO {

	String uname;
	String password;
	String email;
	Date dob;
	
	String password1;
	
	String optionsRadios;
	
	public UserVO() {
		super();
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getOptionsRadios() {
		return optionsRadios;
	}
	public void setOptionsRadios(String optionsRadios) {
		this.optionsRadios = optionsRadios;
	}
	
	
}
