package com.gj.spring.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

public class CustomEntryPoint extends LoginUrlAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest arg0, HttpServletResponse arg1, AuthenticationException arg2)
			throws IOException, ServletException {
		System.out.println("allo entrypoint" +arg0.getSession().getId());
		arg0.getSession().setAttribute("name", "Ganesh");
		
		super.commence(arg0, arg1, arg2);
	}

	public CustomEntryPoint(String loginFormUrl) {
		super(loginFormUrl);
		
	}

}
