package com.mars.tea.springmvc.dao;

import com.mars.tea.springmvc.pojo.Credential;

public interface CredentialDao {
	
	Credential getCredential(String username);
	
	Credential add(Credential credential);
	
	/**
	 * persist user and user credential by cascade
	 * @param user
	 * @return
	 */
	Credential persist(Credential credential);
	
	boolean deleteByUserName(String username);

}
