package com.mars.tea.springmvc.dao.impl;

import org.springframework.stereotype.Repository;

import com.mars.tea.springmvc.dao.AbstractBaseDaoSupport;
import com.mars.tea.springmvc.dao.UserDao;

@Repository("userDao")
public class UserDaoImpl extends AbstractBaseDaoSupport implements UserDao {
	
}
