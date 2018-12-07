package org.jzen.invoicing.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.jzen.invoicing.bean.UserBean;
import org.jzen.invoicing.entity.enums.UserStatusType;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomUserDecorator {

	UserBean p;
	PasswordEncoder passwordEncoder;
	Map<String,String> errors=new HashMap<String,String>();
	UserDetail user;
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	public CustomUserDecorator(UserBean p,PasswordEncoder passwordEncoder,UserDetail usr) {
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
			 user=new UserDetail();
			 user.setDob(p.getDob());
			 user.setEmail(p.getEmail());
			 user.setPassword(passwordEncoder.encode(p.getPassword()));
			 user.setUsername(p.getUname());
			 user.setAuthority("ROLE_ADMIN");
			 user.setUserStatus(UserStatusType.ENABLED.getValue());
			 user.setEnabled(true);
			 user.setSuperAdmin(false);
		}else {
			 user.setDob(p.getDob());
			 user.setEmail(p.getEmail());
			 user.setPassword(passwordEncoder.encode(p.getPassword()));
			 if(p.getEnabled().equals(
					 "enabled")) {
				 user.setEnabled(true);
				 user.setUserStatus(UserStatusType.ENABLED.getValue());
			 }
			 else {
				 user.setEnabled(false);
					user.setUserStatus(UserStatusType.DISABLED.getValue());
			 }
			 
		}
	}

    private Map<String,String> validate(boolean includePassword) {
		return errors;
	}

    public Map<String,String> getErrors() {
    	return errors;
    }

	public UserDetail getCustomUser() {
		return user;
	}
}
