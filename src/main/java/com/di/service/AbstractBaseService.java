package com.di.service;

import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.di.dao.impl.BaseDaoImpl;

public abstract class AbstractBaseService<T> {
	@Autowired
	private BaseDaoImpl baseDaoImpl;

	public T get(Integer id) {
		return baseDaoImpl.get(id, getEntityClass());
	}

	public List<T> findAll() {
		return baseDaoImpl.findAll(getEntityClass());
	}

	public List<T> findAll(Integer pageNum, Integer pageSize) {
		return baseDaoImpl.findAll(getEntityClass(), pageNum, pageSize);
	}

	public List<T> findByMap(String queryName, Map<String, Object> params) {
		return baseDaoImpl.findByMap(queryName, getEntityClass(), params, null, null);
	}

	public List<T> findByMap(String queryName, Map<String, Object> params, int pageNum, int pageSize) {
		return baseDaoImpl.findByMap(queryName, getEntityClass(), params, pageNum, pageSize);
	}

	public T findSingleResultByMap(String queryName, Map<String, Object> params) {
		return baseDaoImpl.findSingleResultByMap(queryName, getEntityClass(), params);
	}

	public Object findUniqueResultByMap(String queryName, Map<String, Object> params) {
		return baseDaoImpl.findUniqueResultByMap(queryName, getEntityClass(), params);
	}

	public Object findUniqueResultByNativeQuery(String sql) {
		return baseDaoImpl.findUniqueResultByNativeQuery(sql);
	}

	public List<T> findByNativeQuery(String sql) {
		return baseDaoImpl.findByNativeQuery(sql, getEntityClass(), null, null);
	}

	public <E> List<E> findByNativeQuery(String sql, Class<E> resultClass, Integer pageNum, Integer pageSize) {
		return baseDaoImpl.findByNativeQuery(sql, resultClass, pageNum, pageSize);
	}

	public List<T> findByJpqlPaged(String jpql, Map<String, Object> params, int pageNum, int pageSize) {
		return baseDaoImpl.findByJpqlPaged(jpql, params, pageNum, pageSize);
	}

	@Transactional
	public void create(T entity) {
		baseDaoImpl.create(entity);
	}

	@Transactional
	public void update(T entity) {
		baseDaoImpl.update(entity);
	}

	@Transactional
	public void delete(T entity) {
		baseDaoImpl.delete(entity);
	}

	public Session getCurrentSession() {
		return baseDaoImpl.getSessionFactory().getCurrentSession();
	}

	public abstract Class<T> getEntityClass();

}
