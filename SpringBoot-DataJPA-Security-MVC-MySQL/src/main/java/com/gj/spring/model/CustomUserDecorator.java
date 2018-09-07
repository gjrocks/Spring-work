package com.gj.spring.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomUserDecorator {

	UserVO p;
	PasswordEncoder passwordEncoder;
	Map<String,String> errors=new HashMap<String,String>();
	CustomUser user;
	
	public CustomUserDecorator(UserVO p,PasswordEncoder passwordEncoder,CustomUser usr) {
		this.p=p;
		this.passwordEncoder=passwordEncoder;
		this.user=usr;
		if(usr==null) {
		validate(true);
		}else {
			if(p.getPassword()==null || p.getPassword().equals("")) {
				validate(false);
			}else {
				validate(true);
			}
		}
		if(errors.isEmpty() && usr==null) {
			 user=new CustomUser();
			 user.setDob(p.getDob());
			 user.setEmail(p.getEmail());
			 user.setPassword(passwordEncoder.encode(p.getPassword()));
			 user.setUsername(p.getUname());
			 user.setAuthority(p.optionsRadios);
			 user.setEnabled(true);
		}else {
			 user.setDob(p.getDob());
			 user.setEmail(p.getEmail());
			 user.setAuthority(p.optionsRadios);
			 user.setEnabled(true);
		}
	}

    private Map<String,String> validate(boolean includePassword) {
		return errors;
	}

    public Map<String,String> getErrors() {
    	return errors;
    }

	public CustomUser getCustomUser() {
		return user;
	}
}
