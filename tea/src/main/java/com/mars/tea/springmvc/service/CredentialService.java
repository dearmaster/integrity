package com.mars.tea.springmvc.service;

import com.mars.tea.springmvc.pojo.Credential;

public interface CredentialService {
	
	Credential getCredential(String username);
	
	Credential register(Credential credential);
	
	boolean deleteByUserName(String username);

}
