package org.jzen.invoicing.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	private static final Logger log = LoggerFactory.getLogger(CustomAuthFailureHandler.class);

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		String errorMessage;
		// this is used to show custom error message based on type of authentication
		// exception
		log.debug("Exception in authentication {1}", exception.getMessage());
		if (exception.getMessage().equalsIgnoreCase("User is disabled")) {
			errorMessage = "User is disabled";
		} else if (exception.getMessage().equalsIgnoreCase("blocked")) {
			errorMessage = "User is currently blocked , Please try after 15 minutes";
		}else {
			errorMessage = "Please enter valid username and password";
		}

		request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, errorMessage);

		getRedirectStrategy().sendRedirect(request, response, "/login?error");

	}

}
