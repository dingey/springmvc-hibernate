package com.di.dao.impl;

import org.springframework.stereotype.Repository;
import com.di.dao.PersonDao;
import com.di.entity.Person;

@Repository("personDao")
public class PersonDaoImpl extends AbstractDaoImpl<Person> implements PersonDao {

	@Override
	public Class<Person> getEntityClass() {
		return Person.class;
	}

}
