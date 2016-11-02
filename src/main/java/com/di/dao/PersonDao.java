package com.di.dao;

import java.util.List;
import com.di.entity.Person;

public interface PersonDao extends AbstractDao<Person> {
	public List<Person> greatThan(int id);
}
