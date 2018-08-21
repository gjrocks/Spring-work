package com.gj.SpringMVCHibernate.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gj.SpringMVCHibernate.model.CustomUser;

public class CustomUserDetails implements UserDetails {

	private CustomUser user;
	
	public CustomUserDetails(CustomUser user){
		this.user=user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return Arrays.asList(this.user.getAuthorities());
	}

	@Override
	public String getPassword() {
	
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
	
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
	
		return true;
	}

}
