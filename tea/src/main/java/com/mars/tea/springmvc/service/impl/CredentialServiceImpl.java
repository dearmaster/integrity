package com.mars.tea.springmvc.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mars.tea.springmvc.aop.DataSource;
import com.mars.tea.springmvc.dao.CredentialDao;
import com.mars.tea.springmvc.pojo.Credential;
import com.mars.tea.springmvc.service.CredentialService;


@Service("credentialService")
public class CredentialServiceImpl implements CredentialService {
	
	private static final Logger logger = Logger.getLogger(CredentialServiceImpl.class);
	
	@Autowired
	@Qualifier("credentialDao")
	private CredentialDao credentialDao;
	
	/**
	 * @Transactional annotation and @DataSource annotation should be placed to the same method
	 * Otherwise the persistent lay code(transaction) will be executed before the aop works
	 */
	@Override
	@Transactional
	@DataSource(name=DataSource.security)
	public Credential getCredential(String username) {
		return credentialDao.getCredential(username);
	}
	
	@Transactional
	@DataSource(name=DataSource.security)
	@Override
	public boolean deleteByUserName(String username) {
		return credentialDao.deleteByUserName(username);
	}

	@Transactional
	@DataSource(name=DataSource.security)
	@Override
	public Credential register(Credential credential) {
		Credential persistCredential = credentialDao.persist(credential);
		if(logger.isDebugEnabled()) {
			logger.debug(persistCredential);
			logger.debug(persistCredential.getUser());
		}
		return persistCredential;
	}

}
