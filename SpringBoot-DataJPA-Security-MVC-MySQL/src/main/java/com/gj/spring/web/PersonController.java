package com.gj.spring.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gj.spring.model.Person;
import com.gj.spring.service.IPersonService;

@Controller
@RequestMapping(value="person")
public class PersonController {

	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
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
		return new ModelAndView("addPersonDetails");
	}

	
	
	@RequestMapping("allPersons")
	public ModelAndView allPersons()
	{
		logger.debug("Getting all persons");
		List<Person> persons = personService.getAllPersons();
		
		ModelAndView mav = new ModelAndView("allPersons");
		mav.addObject("persons", persons);
		return mav;
	}
	
}
