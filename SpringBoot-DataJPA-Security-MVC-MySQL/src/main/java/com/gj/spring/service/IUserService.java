package com.gj.spring.service;

import java.util.List;

import com.gj.spring.model.CustomUser;

public interface IUserService {

	public CustomUser getUser(String username);
	public List<CustomUser> getAllUsers();
	public CustomUser deleteUser(String userName);
	public CustomUser saveUser(CustomUser user);
	
	
}
