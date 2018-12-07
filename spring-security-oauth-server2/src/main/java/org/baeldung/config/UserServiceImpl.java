package org.baeldung.config;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.baeldung.model.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.Cacheable;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	private static final int MAX_ATTEMPTS = 3;
	@Autowired
	UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetail getUserByEmail(String emailId) {
		return userRepository.findByEmail(emailId);
		

	}

	@Override
	public boolean checkIfEmailExists(String email) {

		UserDetail user = userRepository.findByEmail(email);
		if (null != user && null != user.getId()) {
			return true;
		}
		return false;

	}

	@Override
	@Transactional
	public void updateLoginFailedCount(String userName) {
		// check if user exists
		UserDetail user = userRepository.findByUsername(userName);
		if (null == user || null == user.getId()) {
			return;
		}

		userRepository.updateFailedAttempts(userName);
		// check login failed count and block user
		int failedCount = userRepository.getFailedAttemptsCount(userName);
		if (failedCount >= MAX_ATTEMPTS) {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MINUTE, +15);
			userRepository.updateLockDate(userName, cal.getTime());
		}
	}

	@Override
	@Transactional
	public void resetLoginFailedCount(String userName) {
		userRepository.resetFailedAttempts(userName);

	}

	@Override
	@Cacheable("users")
	public List<UserDetail> findAll() {
		return userRepository.findAll();
		

	}

	@Override
	public UserDetail getUser(String username) {

		return userRepository.findByUsername(username);
	}

	@Override
	@Transactional
	public void persistUser(UserDetail user) {
		Date dt = new Date();
		if (null == user.getId() || user.getId() == 0) {

			user.setCreatedDate(dt);
			user.setUpdatedDate(dt);
		} else {
			user.setUpdatedDate(dt);
		}
		// check if it does saveorupdate
		userRepository.save(user);

	}

	@Override
	public List<UserDetail> getAllUsers() {

		return userRepository.findAll();
	}

	@Override
	@Transactional
	public void updatePasswordToken(UserDetail user, String token) {

	
		user.setPassword(passwordEncoder.encode(token));
		//if user is locked , unlock 
		if(user.getFailedAttempts()>=MAX_ATTEMPTS) {
			user.setFailedAttempts(0);
			user.setLockedUntilDate(null);
		}
		
	
		userRepository.save(user);

	}

}
