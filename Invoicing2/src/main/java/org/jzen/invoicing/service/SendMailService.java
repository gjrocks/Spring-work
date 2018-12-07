package org.jzen.invoicing.service;

import org.jzen.invoicing.entity.UserDetail;

public interface SendMailService {
	
	public boolean sendPasswordInEmail(UserDetail user,String password);

}
