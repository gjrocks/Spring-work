package com.gj.spring.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public ModelAndView saveUser(@ModelAttribute("userDetails") @Valid  UserVO userDetails, BindingResult result, ModelMap model)
	{
		CustomUser usr=null;
		CustomUserDecorator customUserdecorator=null;
		Map<String,String> errorMsg=null;
		
		
		usr=userService.getUser(userDetails.getUname());
		customUserdecorator=new CustomUserDecorator(userDetails,passwordEncoder,usr);
		errorMsg=customUserdecorator.getErrors();
		//add above error messages to the binding results
		if (result.hasErrors())
		{
			ModelAndView mav = new ModelAndView("addUserDetails");
			mav.addObject("errors", result);
			mav.addObject("userDetails",userDetails);
			return mav;
		}
		
		//ValidationUtils.(result, "name", "name.required");
		//result.addError(arg0);
		
		if(errorMsg.isEmpty()) {
		userService.saveUser(customUserdecorator.getCustomUser());
		}
		
		//else log errors
		
		return new ModelAndView("redirect:allUsers");
	}

	@RequestMapping(value="addUser")
	public ModelAndView addUser(HttpServletRequest request, UserVO userDetails)
	{
		
		ModelAndView v= new ModelAndView("addUserDetails");
		String userName=request.getParameter("usern");
		UserVO vo=new UserVO();
		
		if(userName !=null && !userName.trim().equals("")) {
		CustomUser usr=userService.getUser(userName);
		if(usr!=null) {
			vo.setDob(usr.getDob());
			vo.setUname(userName);
			vo.setEmail(usr.getEmail());
			vo.setOptionsRadios(usr.getAuthority());
			v.addObject("editMode",true);
		}
		
		}
	
		v.addObject("userDetails",vo);
		/*if(userName !=null && !userName.trim().equals("")) {
		CustomUser usr=userService.getUser(userName);
		
		v.addObject("usrr",usr);
		}*/
		//v.addObject(m.asMap());
		return v;
	}

	
	@RequestMapping(value="deleteUser")
	public ModelAndView deleteUser(HttpServletRequest request, UserVO userDetails)
	{
		
		ModelAndView v= new ModelAndView("redirect:allUsers");
		String userName=request.getParameter("usern");
		
		
		if (userName != null && !userName.trim().equals("")) {
			CustomUser usr = userService.getUser(userName);
			if (usr != null) {
				usr.setEnabled(false);
				userService.saveUser(usr);
			}

		}
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
