package com.di.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.di.dao.PersonDao;
import com.di.entity.Person;

@Repository("personDao")
public class PersonDaoImpl extends AbstractDaoImpl<Person> implements PersonDao {

	@Override
	public Class<Person> getEntityClass() {
		return Person.class;
	}

	@SuppressWarnings("unchecked")
	public List<Person> greatThan(int id) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria c = session.createCriteria(Person.class);
		c.add(Restrictions.ge("id", id));
		return c.list();

	}
}
