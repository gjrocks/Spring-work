package org.jzen.invoicing.validator;


import java.lang.reflect.InvocationTargetException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.PropertyUtils;

public class CheckPasswordMatchValidator implements ConstraintValidator<CheckPasswordMatchConstraint, Object> {

	private String password;
	private String retypedPassword;

	@Override
	public void initialize(CheckPasswordMatchConstraint passwords) {
		this.password = passwords.first();
		this.retypedPassword = passwords.second();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		String pass;
		try {
			pass = (String) PropertyUtils.getProperty(value, this.password);
			String retypedPass = (String) PropertyUtils.getProperty(value, this.retypedPassword);
			return pass.equals(retypedPass);
		} catch (IllegalAccessException e) {
			return false;
		} catch (InvocationTargetException e) {
			return false;
		} catch (NoSuchMethodException e) {
			return false;
		}

	}

}
