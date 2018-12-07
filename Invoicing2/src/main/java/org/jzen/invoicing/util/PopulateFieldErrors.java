package org.jzen.invoicing.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Component
public class PopulateFieldErrors {
	
	//common method to add get all feild errors in map
	public Map<String,String> populateErrors(BindingResult result){
		Map<String,String> fieldErrors= new HashMap<String,String>();
		List<FieldError> errorList=result.getFieldErrors();
		for(FieldError error:errorList) {
			fieldErrors.put(error.getField(), error.getDefaultMessage());
		}
		return fieldErrors;
	}

}
