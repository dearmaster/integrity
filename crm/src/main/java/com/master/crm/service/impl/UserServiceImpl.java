package com.master.crm.service.impl;

import com.master.crm.model.User;
import com.master.crm.service.UserService;
import org.apache.log4j.Logger;

import java.util.Set;

public class UserServiceImpl implements UserService {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Override
    public void add(User user, String password) {
        if(logger.isDebugEnabled()) {
            logger.debug(user + " : " + password);
        }
    }

    @Override
    public void del(User user) {
        if(logger.isDebugEnabled()) {
            logger.debug(user);
        }
    }

    @Override
    public void upd(User user) {
        if(logger.isDebugEnabled()) {
            logger.debug(user);
        }
    }

    @Override
    public User find(String username) {
        return null;
    }

    @Override
    public Set<User> loadAll() {
        return null;
    }

}
