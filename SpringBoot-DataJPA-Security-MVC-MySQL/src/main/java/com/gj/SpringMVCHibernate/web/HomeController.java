package com.gj.SpringMVCHibernate.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gj.SpringMVCHibernate.model.CustomUser;
import com.gj.SpringMVCHibernate.model.Person;



@Controller 
public class HomeController {
	/*@Autowired
	private RootUserCreatorService rootUserCreatorService;
	*/
	@RequestMapping(value="home", method=RequestMethod.GET)
	public ModelAndView addPerson(Person p, Errors errors)
	{
		
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

	/*@RequestMapping(value="custlogin", method=RequestMethod.GET)
	public ModelAndView loginn()
	{
		
		ModelAndView mav = new ModelAndView("custlogin");
		return mav;
	}*/
	@RequestMapping(value="registerform", method=RequestMethod.GET)
	public ModelAndView registerform(CustomUser p, Errors errors)
	{
		ModelAndView mav = new ModelAndView("register","register",p);
		return mav;
	}	
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	public ModelAndView register(@ModelAttribute CustomUser p, Errors errors)
	{
		//save customuser
		System.out.println(p);
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}	
}
