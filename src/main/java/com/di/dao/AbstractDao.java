package com.di.dao;

import java.util.List;
import java.util.Map;

public interface AbstractDao<T> {

	public T get(Integer id);

	public List<T> findAll();

	public List<T> findAll(int pageNum, int pageSize);

	public List<T> findByMap(String queryName, Map<String, Object> params);

	public List<T> findByMap(String queryName, Map<String, Object> params, int pageNum, int pageSize);

	public T findSingleResultByMap(String queryName, Map<String, Object> params);

	public T findSingleResultByOneParam(String queryName, String param, Object value);

	public Object findSingleValueByMap(String queryName, Map<String, Object> params);

	public List<T> findByNativeQuery(String sql);

	public void create(T entity);

	public void update(T entity);

	public void delete(T entity);

}
