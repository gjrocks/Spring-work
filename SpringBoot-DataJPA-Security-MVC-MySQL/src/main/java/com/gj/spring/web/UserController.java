package com.gj.spring.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gj.spring.model.CustomUser;
import com.gj.spring.model.CustomUserDecorator;
import com.gj.spring.model.UserVO;
import com.gj.spring.service.IUserService;

@Controller
@RequestMapping(value="user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	IUserService userService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@RequestMapping(value="saveUser", method=RequestMethod.POST)
	public ModelAndView addUser(UserVO p, Errors errors)
	{
		CustomUser usr=null;
		CustomUserDecorator customUserdecorator=null;
		Map<String,String> errorMsg=null;
		
		if (errors.hasErrors())
		{
			ModelAndView mav = new ModelAndView("addUser");
			mav.addObject("errors", errors);
			return mav;
		}
		usr=userService.getUser(p.getUname());
		customUserdecorator=new CustomUserDecorator(p,passwordEncoder,usr);
		errorMsg=customUserdecorator.getErrors();
		if(errorMsg.isEmpty()) {
		userService.addUser(customUserdecorator.getCustomUser());
		}
		//else log errors
		
		return new ModelAndView("redirect:allUsers");
	}

	@RequestMapping(value="addUser")
	public ModelAndView addUser(HttpServletRequest request)
	{
		//String userName=request.getParameter("usern");
		ModelAndView v= new ModelAndView("addUserDetails");
		/*if(userName !=null && !userName.trim().equals("")) {
		CustomUser usr=userService.getUser(userName);
		
		v.addObject("usrr",usr);
		}*/
		//v.addObject(m.asMap());
		return v;
	}

	@RequestMapping(value="updateUser")
	public ModelAndView updateUser(HttpServletRequest request)
	{
		String userName=request.getParameter("usern");
		ModelAndView v= new ModelAndView("updateUserDetails");
		if(userName !=null && !userName.trim().equals("")) {
			CustomUser usr=userService.getUser(userName);
			
		
		v.addObject("usrr",usr);
		}
		//v.addObject(m.asMap());
		return v;
	}
	
	@RequestMapping("allUsers")
	public ModelAndView allPersons()
	{
		logger.debug("Getting all users");
		List<CustomUser> users = userService.getAllUsers();
		
		ModelAndView mav = new ModelAndView("allUsers");
		mav.addObject("users", users);
		return mav;
	}
	
}
