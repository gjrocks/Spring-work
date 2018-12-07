package org.baeldung.config;

import java.util.Arrays;
import java.util.List;

import org.baeldung.model.CustomAuthories;
import org.baeldung.model.UserDetail;
import org.baeldung.util.InvoicingUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	//@Autowired
	private InvoicingUtil invoicingUtil=new InvoicingUtil();

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		UserDetail user = userRepository.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("User not found.");

		} else if (invoicingUtil.isUserLocked(user.getLockedUntilDate())) {
			throw new RuntimeException("blocked");
		} else {
			
			List<CustomAuthories> li=Arrays.asList(user.getAuthorities());
			
			UserDetails userDetails = (UserDetails) new User(user.getName(), user.getPassword(), user.isEnabled(), true, true, true,
					li);

			return userDetails;
		}

	}

	

}
