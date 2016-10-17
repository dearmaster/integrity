package com.master.crm.dao.impl;

import com.master.crm.dao.AbstractBaseDaoSupport;
import com.master.crm.dao.UserDao;
import com.master.crm.model.User;

import java.util.Set;

public class UserDaoImpl extends AbstractBaseDaoSupport<User> implements UserDao {

    public Set<User> load() {
        return super.load(User.class);
    }
}