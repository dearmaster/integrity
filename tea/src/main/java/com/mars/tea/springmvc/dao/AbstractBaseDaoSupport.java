package com.mars.tea.springmvc.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class AbstractBaseDaoSupport {
	
	private SessionFactory sessionFactory;
	
	@Resource
	public void setSessionFactory(SessionFactory sessionFactoryHibernate) {
		this.sessionFactory = sessionFactoryHibernate;
	}


	protected final Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
}
