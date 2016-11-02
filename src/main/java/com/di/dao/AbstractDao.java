package com.di.dao;

import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;

public interface AbstractDao<T> {

	public T get(Integer id);

	public List<T> findAll();

	public List<T> findAll(Integer pageNum, Integer pageSize);

	public List<T> findByMap(String queryName, Map<String, Object> params, Integer pageNum, Integer pageSize);

	public T findSingleResultByMap(String queryName, Map<String, Object> params);

	public T findSingleResultByOneParam(String queryName, String param, Object value);

	public Object findUniqueResultByMap(String queryName, Map<String, Object> params);

	public Object findUniqueResultByNativeQuery(String sql);

	public List<T> findByNativeQuery(String sql, Integer pageNum, Integer pageSize);

	public <E> List<E> findByNativeQuery(String sql, Class<E> e, Integer pageNum, Integer pageSize);

	public List<T> findByJpqlPaged(String jpql, Map<String, Object> params, Integer pageNum, Integer pageSize);

	public List<T> criteria(Criteria c);

	public void create(T entity);

	public void update(T entity);

	public void delete(T entity);

}
