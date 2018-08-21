package com.gj.spring.service;

import java.util.List;

import com.gj.spring.model.Person;

public interface IPersonService {

	public Person persistPerson(Person p);
	public List<Person> getAllPersons();
}
