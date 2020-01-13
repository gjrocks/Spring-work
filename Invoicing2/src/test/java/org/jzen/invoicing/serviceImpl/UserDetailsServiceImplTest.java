package org.jzen.invoicing.serviceImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.jzen.invoicing.entity.UserDetail;
import org.jzen.invoicing.repository.UserRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
@RunWith(MockitoJUnitRunner.class)
public class UserDetailsServiceImplTest {

	@Mock
	UserRepository userRepositoryMock;
	
	@Mock
	private PasswordEncoder passwordEncoder;
	
	@InjectMocks
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Test
	public void loadUserByUsernameTest() {
		UserDetail userDetail = new UserDetail("test","qwerty","test12",true,"ADMIN",new Date());
		when(userRepositoryMock.findByUsername("test")).thenReturn(userDetail);
		UserDetails userDetailreturned = userDetailsServiceImpl.loadUserByUsername("test");
		
		assertEquals("test", userDetailreturned.getUsername());
		
		assertEquals("test12", userDetailreturned.getPassword());
		
		
	}
	
	@Test(expected = UsernameNotFoundException.class)
	public void testUserNameNotFoundException() {
		when(userRepositoryMock.findByUsername("test")).thenReturn(null);
		userDetailsServiceImpl.loadUserByUsername("test");
	}
	
	@Test(expected = RuntimeException.class)
	public void testRuntimeException() {
		UserDetail userDetail = new UserDetail("test","qwerty","test12",true,"ADMIN",new Date());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, +15);
		userDetail.setLockedUntilDate(cal.getTime());
		when(userRepositoryMock.findByUsername("test")).thenReturn(userDetail);
		userDetailsServiceImpl.loadUserByUsername("test");
	}
	
	@Test
	public void testUserIsDisabled() {
		UserDetail userDetail = new UserDetail("test","qwerty","test12",false,"ADMIN",new Date());
		
		when(userRepositoryMock.findByUsername("test")).thenReturn(userDetail);
		UserDetails userDetailreturned = userDetailsServiceImpl.loadUserByUsername("test");
		assertEquals(false, userDetailreturned.isEnabled());
	}
	

	
}
