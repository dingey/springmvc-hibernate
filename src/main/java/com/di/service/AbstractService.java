package com.di.service;

import java.util.List;
import java.util.Map;

public interface AbstractService<T> {
	public T get(Integer id);

	public List<T> findAll();

	public List<T> findAll(int pageNum, int pageSize);

	public List<T> findByMap(String queryName, Map<String, Object> params);

	public List<T> findByMap(String queryName, Map<String, Object> params, int pageNum, int pageSize);

	public T findSingleResultByMap(String queryName, Map<String, Object> params);

	public Object findSingleValueByMap(String queryName, Map<String, Object> params);

	public List<T> findByNativeQuery(String sql);

	public void create(T entity);

	public void update(T entity);

	public void delete(T entity);

}
