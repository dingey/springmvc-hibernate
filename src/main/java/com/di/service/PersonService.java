package com.di.service;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.di.dao.AbstractDao;
import com.di.dao.PersonDao;
import com.di.entity.Person;
import com.di.param.PersonParam;

@Service("personService")
public class PersonService extends AbstractServiceImpl<Person> {
	@Autowired
	private PersonDao personDao;

	@Override
	public AbstractDao<Person> getAbstractDao() {
		return personDao;
	}

	@SuppressWarnings("unchecked")
	public List<Person> findByParam(PersonParam param) {
		Criteria c = getCurrentSession().createCriteria(Person.class);
		if (param.getId() != null) {
			c.add(Restrictions.eq("id", param.getId()));
		}
		if (param.getName() != null) {
			c.add(Restrictions.like("name", "%" + param.getName() + "%"));
		}
		if (param.getAge() != null) {
			c.add(Restrictions.gt("age", param.getAge()));
		}
		if (param.getSex() != null) {
			c.add(Restrictions.eq("sex", param.getSex()));
		}
		return c.list();
	}

	public Object findCountByParam(PersonParam param) {
		Criteria c = getCurrentSession().createCriteria(Person.class.getName());
		if (param.getId() != null) {
			c.add(Restrictions.eq("id", param.getId()));
		}
		if (param.getName() != null) {
			c.add(Restrictions.like("name", "%" + param.getName() + "%"));
		}
		if (param.getAge() != null) {
			c.add(Restrictions.gt("age", param.getAge()));
		}
		if (param.getSex() != null) {
			c.add(Restrictions.eq("sex", param.getSex()));
		}
		c.setProjection(Projections.rowCount());
		return Integer.parseInt(c.uniqueResult().toString());
	}

}
