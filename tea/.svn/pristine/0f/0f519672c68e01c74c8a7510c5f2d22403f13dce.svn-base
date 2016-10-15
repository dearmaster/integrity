package com.mars.tea.springmvc.dao.impl;

import static com.mars.tea.springmvc.consts.SqlStrings.HQL_USER_GET_CREDENTIAL;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.mars.tea.springmvc.dao.AbstractBaseDaoSupport;
import com.mars.tea.springmvc.dao.CredentialDao;
import com.mars.tea.springmvc.pojo.Credential;

@Repository("credentialDao")
public class CredentialDaoImpl extends AbstractBaseDaoSupport implements CredentialDao {

	@SuppressWarnings("unchecked")
	@Override
	//@DataSource(name=DataSource.security)
	public Credential getCredential(String username) {
		
		Session session = this.getSession();
		List<Credential> credentials = session.createQuery(HQL_USER_GET_CREDENTIAL).setParameter("username", username).list();
		if(credentials != null && credentials.size() == 1)
			return credentials.get(0);
		return null;
	}
	
	@Override
	public Credential persist(Credential credential) {
		Session session = this.getSession();
		session.persist(credential);
		return credential;
	}

	@Override
	public Credential add(Credential credential) {
		Session session = this.getSession();
		session.save(credential);
		return credential;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteByUserName(String username) {
		
		Session session = this.getSession();
		List<Credential> credentials = session.createQuery(HQL_USER_GET_CREDENTIAL).setParameter("username", username).list();
		if(credentials != null && credentials.size() == 1) {
			session.delete(credentials.get(0));
			session.flush();
			return true;
		}
		return false;
	}
}
