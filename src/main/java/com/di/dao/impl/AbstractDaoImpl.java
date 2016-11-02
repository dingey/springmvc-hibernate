package com.di.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import com.di.dao.AbstractDao;

public abstract class AbstractDaoImpl<T> implements AbstractDao<T> {
	@Autowired
	private SessionFactory sessionFactory;

	public T get(Integer id) {
		return sessionFactory.getCurrentSession().get(getEntityClass(), id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.getNamedQuery(getEntityClass().getSimpleName() + ".findAll");
		return q.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll(Integer pageNum, Integer pageSize) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.getNamedQuery(getEntityClass().getSimpleName() + ".findAll");
		q.setFirstResult(pageNum).setMaxResults(pageSize);
		return q.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> findByMap(String queryName, Map<String, Object> params) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.getNamedQuery(queryName);
		for (String param : params.keySet()) {
			q.setParameter(param, params.get(param));
		}
		return q.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> findByMap(String queryName, Map<String, Object> params, Integer pageNum, Integer pageSize) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.getNamedQuery(queryName);
		if (params != null) {
			for (String param : params.keySet()) {
				q.setParameter(param, params.get(param));
			}
		}
		if (pageNum != null && pageSize != null) {
			q.setFirstResult(pageNum * pageSize - pageSize);
			q.setMaxResults(pageSize);
		}
		return q.list();
	}

	@SuppressWarnings("unchecked")
	public T findSingleResultByMap(String queryName, Map<String, Object> params) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.getNamedQuery(queryName);
		for (String param : params.keySet()) {
			q.setParameter(param, params.get(param));
		}
		return q.list().isEmpty() ? null : (T) q.list().get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findSingleResultByOneParam(String queryName, String paramName, Object paramValue) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.getNamedQuery(queryName);
		q.setParameter(paramName, paramValue);
		List<T> l = q.list();
		return l.isEmpty() ? null : l.get(0);
	}

	public Object findUniqueResultByMap(String queryName, Map<String, Object> params) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.getNamedQuery(queryName);
		if (params != null) {
			for (String param : params.keySet()) {
				q.setParameter(param, params.get(param));
			}
		}
		return q.uniqueResult();
	}

	public Object findUniqueResultByNativeQuery(String sql) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery q = session.createSQLQuery(sql);
		return q.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<T> findByNativeQuery(String sql, Integer pageNum, Integer pageSize) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery q = session.createSQLQuery(sql);
		if (pageNum != null && pageSize != null) {
			q.setFirstResult((pageNum - 1) * pageSize);
			q.setMaxResults(pageSize);
		}
		q.addEntity(getEntityClass());
		return q.list();
	}

	@SuppressWarnings("unchecked")
	public <E> List<E> findByNativeQuery(String sql, Class<E> e, Integer pageNum, Integer pageSize) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery q = session.createSQLQuery(sql);
		if (pageNum != null && pageSize != null) {
			q.setFirstResult((pageNum - 1) * pageSize);
			q.setMaxResults(pageSize);
		}
		q.setResultTransformer(Transformers.aliasToBean(e));
		return q.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> findByJpqlPaged(String jpql, Map<String, Object> params, Integer pageNum, Integer pageSize) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(jpql);
		if (params != null) {
			for (String key : params.keySet()) {
				query.setParameter(key, params.get(key));
			}
		}
		if (pageNum != null && pageSize != null) {
			query.setFirstResult((pageNum - 1) * pageSize);
			query.setMaxResults(pageSize);
		}
		return query.list();
	}

	public void create(T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(entity);
	}

	@SuppressWarnings("unchecked")
	public void update(T entity) {
		Session session = sessionFactory.getCurrentSession();
		entity = (T) session.merge(entity);
		session.persist(entity);
	}

	public void delete(T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(entity);
	}

	public abstract Class<T> getEntityClass();

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> criteria(Criteria c) {
		return c.list();
	}
}
