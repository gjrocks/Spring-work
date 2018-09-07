package com.gj.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gj.spring.model.Person;
import com.gj.spring.model.PersonRepository;


@Service
public class PersonService implements IPersonService {

	

	
	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public Person persistPerson(Person p) {
	System.out.println("Persisting person");
	personRepository.save(p);
		
		return p;
	}

	@Override
	public List<Person> getAllPersons() {
		/*List<Person> persons = sessionFactory.getCurrentSession().
				createQuery("FROM Person").list();*/
		List<Person> persons =null;
		persons=personRepository.findAll();
		return persons;
	}

	
}
