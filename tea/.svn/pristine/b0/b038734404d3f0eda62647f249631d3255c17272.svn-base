package com.mars.tea.springmvc.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mars.tea.springmvc.dao.UserDao;
import com.mars.tea.springmvc.pojo.User;
import com.mars.tea.springmvc.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;


	@Override
	public boolean delete(User user) {
		return false;
	}

	@Override
	public boolean update(User user) {
		return false;
	}

	@Override
	public User get(String username) {
		return null;
	}

	@Override
	public List<User> load() {
		return null;
	}

}
