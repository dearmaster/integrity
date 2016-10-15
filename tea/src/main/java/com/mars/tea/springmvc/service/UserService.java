package com.mars.tea.springmvc.service;

import java.util.List;

import com.mars.tea.springmvc.pojo.User;

public interface UserService {
	
	
	boolean delete(User user);
	
	
	boolean update(User user);
	
	/**
	 * Retrieve specified user by given username
	 * @param username
	 * @return
	 */
	User get(String username);
	
	/**
	 * Retrieve all the users in current system
	 * @return
	 */
	List<User> load();
	
}