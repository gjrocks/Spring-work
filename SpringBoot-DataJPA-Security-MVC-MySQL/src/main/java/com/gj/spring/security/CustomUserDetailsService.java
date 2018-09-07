package com.gj.spring.security;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gj.spring.model.CustomUser;
import com.gj.spring.service.IUserService;
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Resource
	PasswordEncoder passwordEncoder;
	
	 @Autowired
	 private IUserService userService;

	 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		//CustomUser user = new CustomUser(1, "admin", passwordEncoder.encode("admin"), true, "ROLE_USER,ROLE_ADMIN,ROLE_ORG");
		CustomUser user=userService.getUser(username);
		UserDetails userDetails = new CustomUserDetails(user);

		return userDetails;
	}

}
