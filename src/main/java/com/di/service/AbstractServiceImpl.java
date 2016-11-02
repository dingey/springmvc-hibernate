package com.di.service;

import java.util.List;
import java.util.Map;
import org.springframework.transaction.annotation.Transactional;
import com.di.dao.AbstractDao;

public abstract class AbstractServiceImpl<T> {

	public T get(Integer id) {
		return getAbstractDao().get(id);
	}

	public List<T> findAll() {
		return getAbstractDao().findAll();
	}

	public List<T> findAll(Integer pageNum, Integer pageSize) {
		return getAbstractDao().findAll(pageNum, pageSize);
	}

	public List<T> findByMap(String queryName, Map<String, Object> params) {
		return getAbstractDao().findByMap(queryName, params, null, null);
	}

	public List<T> findByMap(String queryName, Map<String, Object> params, int pageNum, int pageSize) {
		return getAbstractDao().findByMap(queryName, params, pageNum, pageSize);
	}

	public T findSingleResultByMap(String queryName, Map<String, Object> params) {
		return getAbstractDao().findSingleResultByMap(queryName, params);
	}

	public Object findUniqueResultByMap(String queryName, Map<String, Object> params) {
		return getAbstractDao().findUniqueResultByMap(queryName, params);
	}

	public Object findUniqueResultByNativeQuery(String sql) {
		return getAbstractDao().findUniqueResultByNativeQuery(sql);
	}

	public List<T> findByNativeQuery(String sql) {
		return getAbstractDao().findByNativeQuery(sql, null, null);
	}

	public <E> List<E> findByNativeQuery(String sql, Class<E> e, Integer pageNum, Integer pageSize) {
		return getAbstractDao().findByNativeQuery(sql, e, pageNum, pageSize);
	}

	public List<T> findByJpqlPaged(String jpql, Map<String, Object> params, int pageNum, int pageSize) {
		return getAbstractDao().findByJpqlPaged(jpql, params, pageNum, pageSize);
	}

	@Transactional
	public void create(T entity) {
		getAbstractDao().create(entity);
	}

	@Transactional
	public void update(T entity) {
		getAbstractDao().update(entity);
	}

	@Transactional
	public void delete(T entity) {
		getAbstractDao().delete(entity);
	}

	public abstract AbstractDao<T> getAbstractDao();

}
