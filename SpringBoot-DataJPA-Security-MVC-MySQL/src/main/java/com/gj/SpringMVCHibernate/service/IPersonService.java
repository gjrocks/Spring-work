package com.gj.SpringMVCHibernate.service;

import java.util.List;

import com.gj.SpringMVCHibernate.model.Person;

public interface IPersonService {

	public Person persistPerson(Person p);
	public List<Person> getAllPersons();
}
