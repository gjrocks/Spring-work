package org.jzen.invoicing.serviceImpl;

import org.junit.runner.RunWith;
import org.jzen.invoicing.repository.UserRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

@RunWith(MockitoJUnitRunner.class)  
public class LoginServiceTest {
	
	@Mock
	UserRepository userRepositoryMock;
	@Mock
	private PasswordEncoder passwordEncoder;

	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	
	
	
	
	


}
