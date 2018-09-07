package com.gj.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gj.spring.model.CustomUser;
import com.gj.spring.model.UserRepository;

@Service
public class UserService implements IUserService {
@Autowired
private UserRepository userRepository;
	@Override
	public CustomUser getUser(String username) {
		
		return userRepository.findByUsername(username);
	}

	@Override
	public List<CustomUser> getAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public CustomUser deleteUser(String userName) {
		
		return null;
	}

	@Override
	public CustomUser addUser(CustomUser user) {
		System.out.println("here");
		Date dt=new Date();
		if(user.getId()==0) {
			
			user.setDateCreated(dt);
			user.setDateUpdated(dt);
		}else {
			user.setDateUpdated(dt);
		}
			
		userRepository.save(user);
		return user;
	}

}
