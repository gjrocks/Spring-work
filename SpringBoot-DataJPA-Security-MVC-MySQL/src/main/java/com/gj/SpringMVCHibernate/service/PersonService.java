package com.gj.SpringMVCHibernate.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gj.SpringMVCHibernate.model.Person;
@Service
public class PersonService implements IPersonService {

	@Autowired
	private IRemoteManager remoteManager;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Person persistPerson(Person p) {
	System.out.println("Persisting person");
	remoteManager.getSomethingFromSomeWhere();
		sessionFactory.getCurrentSession().save(p);
		return p;
	}

	@Override
	public List<Person> getAllPersons() {
		List<Person> persons = sessionFactory.getCurrentSession().
				createQuery("FROM Person").list();
		return persons;
	}

}
