package org.jzen.invoicing.controller.advice;

import java.security.Principal;

import org.jzen.invoicing.util.FormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;



@ControllerAdvice
public class UserControllerAdvice {
	
	@Autowired
	FormatUtils formatUtils;
	
    @ModelAttribute("username")
    public String username(Principal principal) {
        return principal == null ? null : formatUtils.capitaliseFirstLetter(principal.getName());
    }
}