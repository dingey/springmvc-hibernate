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
import org.springframework.stereotype.Repository;

@Repository
public class BaseDaoImpl {
	@Autowired
	private SessionFactory sessionFactory;

	public <T> T get(Integer id, Class<T> entityClass) {
		return sessionFactory.getCurrentSession().get(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findAll(Class<T> entityClass) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.getNamedQuery(entityClass.getSimpleName() + ".findAll");
		return q.list();
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findAll(Class<T> entityClass, Integer pageNum, Integer pageSize) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.getNamedQuery(entityClass.getSimpleName() + ".findAll");
		q.setFirstResult(pageNum).setMaxResults(pageSize);
		return q.list();
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findByMap(String queryName, Class<T> entityClass, Map<String, Object> params, Integer pageNum,
			Integer pageSize) {
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
	public <T> T findSingleResultByMap(String queryName, Class<T> entityClass, Map<String, Object> params) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.getNamedQuery(queryName);
		for (String param : params.keySet()) {
			q.setParameter(param, params.get(param));
		}
		return q.list().isEmpty() ? null : (T) q.list().get(0);
	}

	@SuppressWarnings("unchecked")
	public <T> T findSingleResultByOneParam(String queryName, String paramName, Object paramValue) {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.getNamedQuery(queryName);
		q.setParameter(paramName, paramValue);
		List<T> l = q.list();
		return l.isEmpty() ? null : l.get(0);
	}

	public <T> Object findUniqueResultByMap(String queryName, Class<T> entityClass, Map<String, Object> params) {
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
	public <T> List<T> findByNativeQuery(String sql, Class<T> entityClass, Integer pageNum, Integer pageSize) {
		Session session = sessionFactory.getCurrentSession();
		SQLQuery q = session.createSQLQuery(sql);
		if (pageNum != null && pageSize != null) {
			q.setFirstResult((pageNum - 1) * pageSize);
			q.setMaxResults(pageSize);
		}
		q.setResultTransformer(Transformers.aliasToBean(entityClass));
		return q.list();
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> findByJpqlPaged(String jpql, Map<String, Object> params, Integer pageNum, Integer pageSize) {
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

	public <T> void create(T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(entity);
	}

	@SuppressWarnings("unchecked")
	public <T> void update(T entity) {
		Session session = sessionFactory.getCurrentSession();
		entity = (T) session.merge(entity);
		session.persist(entity);
	}

	public <T> void delete(T entity) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(entity);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> criteria(Criteria c) {
		return c.list();
	}
}
