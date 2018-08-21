package com.gj.SpringMVCHibernate.web;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gj.SpringMVCHibernate.model.Person;
import com.gj.SpringMVCHibernate.service.IPersonService;

@Controller
@RequestMapping(value="person")
public class PersonController {


	@Autowired
	IPersonService personService;

	@RequestMapping(value="savePerson", method=RequestMethod.POST)
	public ModelAndView addPerson(Person p, Errors errors)
	{
		
		if (errors.hasErrors())
		{
			ModelAndView mav = new ModelAndView("addPerson");
			mav.addObject("errors", errors);
			return mav;
		}
		personService.persistPerson(p);
			
		return new ModelAndView("redirect:allPersons");
	}

	@RequestMapping(value="addPerson")
	public ModelAndView addPerson()
	{
		return new ModelAndView("addPerson");
	}

	
	
	@RequestMapping("allPersons")
	public ModelAndView allPersons()
	{
		List<Person> persons = personService.getAllPersons();
		
		ModelAndView mav = new ModelAndView("allPersons");
		mav.addObject("persons", persons);
		return mav;
	}
	
}
