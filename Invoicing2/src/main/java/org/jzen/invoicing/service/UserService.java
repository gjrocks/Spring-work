package org.jzen.invoicing.service;

import java.util.List;


import org.jzen.invoicing.entity.UserDetail;

public interface UserService {

	public void updateLoginFailedCount(String userName);

	void resetLoginFailedCount(String userName);

	public void persistUser(UserDetail user);

	public void updatePasswordToken(UserDetail user, String token);

	UserDetail getUser(String username);

	List<UserDetail> getAllUsers();

	List<UserDetail> findAll();

	UserDetail getUserByEmail(String emailId);

	boolean checkIfEmailExists(String email);

	

}
