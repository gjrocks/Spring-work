package com.gj.spring.model;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.gj.spring.security.DateWrapper;
import com.gj.spring.service.IUserService;

@Component
public class InitialData {
    @Autowired
    private IUserService userService;

    
    @Resource
	PasswordEncoder passwordEncoder;
    
    @PostConstruct
    public void init() {
        //   initUsers();
    }

    private void initUsers() {
        //final Privilege privilege1 = privilegeRepository.findByName("FOO_READ_PRIVILEGE");
        //final Privilege privilege2 = privilegeRepository.findByName("FOO_WRITE_PRIVILEGE");
        //
        final CustomUser user1 = new CustomUser();
        user1.setUsername("demo");
        user1.setPassword(passwordEncoder.encode("demo"));
        user1.setAuthority("ROLE_ADMIN");
        user1.setEnabled(true);
        user1.setEmail("demo@demo.com");
        user1.setDob(new DateWrapper(12,12,1980).getDate());
        userService.addUser(user1);
        /*//
        final User user2 = new User();
        user2.setUsername("tom");
        user2.setPassword("111");
        user2.setPrivileges(new HashSet<Privilege>(Arrays.asList(privilege1, privilege2)));
        user2.setOrganization(organizationRepository.findByName("SecondOrg"));
        userRepository.save(user2);*/
    }

   
}
