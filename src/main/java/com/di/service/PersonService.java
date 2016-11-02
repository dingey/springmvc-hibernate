package com.di.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.di.dao.AbstractDao;
import com.di.dao.PersonDao;
import com.di.entity.Person;

@Service("personService")
public class PersonService extends AbstractServiceImpl<Person> {
	@Autowired
	private PersonDao personDao;

	@Override
	public AbstractDao<Person> getAbstractDao() {
		return personDao;
	}

	public List<Person> criteria(int id) {
		return personDao.greatThan(id);
	}

}
