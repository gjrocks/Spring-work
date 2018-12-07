package org.jzen.invoicing.serviceImpl;

import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.jzen.invoicing.entity.UserDetail;
import org.jzen.invoicing.repository.UserRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
//import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

@RunWith(MockitoJUnitRunner.class)  
public class UserServiceImplTest {

	@Mock
	UserRepository userRepositoryMock;
	@Mock
	private PasswordEncoder passwordEncoder;

	@InjectMocks
	private UserServiceImpl userServiceImpl;

	@Test
	public void updateLoginFailedCountTestFaliureCountisOne() {
		UserDetail userDetail = new UserDetail("test","qwerty","test",true,"ADMIN",new Date());
		

		when(userRepositoryMock.findByUsername("test")).thenReturn(userDetail);

		when(userRepositoryMock.getFailedAttemptsCount("test")).thenReturn(1);
		userServiceImpl.updateLoginFailedCount("test");
	}

	@Test
	public void updateLoginFailedCountTestUserNotExists() {
		when(userRepositoryMock.findByUsername("test")).thenReturn(null);
		userServiceImpl.updateLoginFailedCount("test");
	}

	@Test
	public void updateLoginFailedCountTestFaliureCountisThree() {
		UserDetail userDetail = new UserDetail("test","qwerty","test",true,"ADMIN",new Date());
		userDetail.setUsername("test");
		userDetail.setId(1);

		when(userRepositoryMock.findByUsername("test")).thenReturn(userDetail);

		when(userRepositoryMock.getFailedAttemptsCount("test")).thenReturn(3);
		userServiceImpl.updateLoginFailedCount("test");
	}

}
