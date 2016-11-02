package com.di.service;

import java.util.List;
import java.util.Map;
import com.di.dao.AbstractDao;

public abstract class AbstractServiceImpl<T> {

	public T get(Integer id) {
		return getAbstractDao().get(id);
	}

	public List<T> findAll() {
		return getAbstractDao().findAll();
	}

	public List<T> findAll(int pageNum, int pageSize) {
		return getAbstractDao().findAll(pageNum, pageSize);
	}

	public List<T> findByMap(String queryName, Map<String, Object> params) {
		return getAbstractDao().findByMap(queryName, params);
	}

	public List<T> findByMap(String queryName, Map<String, Object> params, int pageNum, int pageSize) {
		return getAbstractDao().findByMap(queryName, params, pageNum, pageSize);
	}

	public T findSingleResultByMap(String queryName, Map<String, Object> params) {
		return getAbstractDao().findSingleResultByMap(queryName, params);
	}

	public Object findSingleValueByMap(String queryName, Map<String, Object> params) {
		return getAbstractDao().findSingleValueByMap(queryName, params);
	}

	public List<T> findByNativeQuery(String sql) {
		return getAbstractDao().findByNativeQuery(sql);
	}

	public void create(T entity) {
		getAbstractDao().create(entity);
	}

	public void update(T entity) {
		getAbstractDao().update(entity);
	}

	public void delete(T entity) {
		getAbstractDao().delete(entity);
	}

	public abstract AbstractDao<T> getAbstractDao();

}
