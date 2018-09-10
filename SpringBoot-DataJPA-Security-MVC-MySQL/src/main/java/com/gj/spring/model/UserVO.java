package com.gj.spring.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class UserVO {

	@NotEmpty(message = "Data Error :User name should not be blank.")
    @Size(min = 3,max = 10,message="Username should have length between 6 and 10")
	String uname;

	
	String password;
	
	@Email
	String email;
	
	@NotNull(message ="Data Error :Please provide date of birth")
	@DateTimeFormat(pattern="dd/MM/yyyy")
    @Past
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
