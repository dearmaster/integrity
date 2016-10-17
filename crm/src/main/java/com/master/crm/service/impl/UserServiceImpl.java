package com.master.crm.service.impl;

import com.master.crm.dao.UserDao;
import com.master.crm.model.User;
import com.master.crm.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    private UserDao userDao;

    @Override
    public void add(User user, String password) {
        userDao.save(user);
    }

    @Override
    public void del(User user) {
        userDao.del(user);
    }

    @Override
    public void upd(User user) {
        userDao.upd(user);
    }

    @Override
    public User find(String username) {
        return null;
    }

    @Override
    public Set<User> loadAll() {
        return null;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
