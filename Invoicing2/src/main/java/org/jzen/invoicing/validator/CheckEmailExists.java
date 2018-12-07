package org.jzen.invoicing.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.jzen.invoicing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;


public class CheckEmailExists implements ConstraintValidator<CheckEmailExistsConstraint, String>{

	@Autowired
	UserService userService;
	
	
	public boolean isValid(String email, ConstraintValidatorContext arg1) {
		
		if(email==null) {
			return false;
		}
		
		 return !userService.checkIfEmailExists(String.valueOf(email));
		}


	@Override
	public void initialize(CheckEmailExistsConstraint arg0) {
		// TODO Auto-generated method stub
		
	}




}
