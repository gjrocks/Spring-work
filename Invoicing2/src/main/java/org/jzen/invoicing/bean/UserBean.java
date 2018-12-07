package org.jzen.invoicing.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.jzen.invoicing.validator.CheckEmailExistsConstraint;
import org.jzen.invoicing.validator.CheckPasswordMatchConstraint;
import org.jzen.invoicing.validator.DateRangeConstraints;
import org.springframework.format.annotation.DateTimeFormat;
@CheckPasswordMatchConstraint(first="password",second="password1",message="Entered passwords don't match")
public class UserBean {

	private Integer id;

	@NotEmpty(message = "User name should not be blank.")
	@Size(min = 3, max = 10, message = "Username should have length between 6 and 10")
	String uname;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	
	@Size(min = 1, message = "Email Address cannot empty")
	@NotNull(message = "Email Address cannot be null")
	@Email(message="Please enter valid email address.")
	private String email;

	@NotEmpty(message = "Please enter password.")
	private String password;

	private String enabled;
	
	private String dobDisplay;
	private String displayStatus;
	private String createdDate;

	@NotNull(message = "Please provide date of birth.")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Past(message="Date of birth must be a past date. ")
	Date dob;

	@NotEmpty(message = "Please retype entered password.")
	String password1;

	String optionsRadios;

	

	

	public String getDobDisplay() {
		return dobDisplay;
	}

	public void setDobDisplay(String dobDisplay) {
		this.dobDisplay = dobDisplay;
	}

	public String getDisplayStatus() {
		return displayStatus;
	}

	public void setDisplayStatus(String displayStatus) {
		this.displayStatus = displayStatus;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
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
