package com.master.crm.action;

import com.master.crm.model.User;
import com.opensymphony.xwork2.ActionProxy;
import org.apache.struts2.StrutsSpringTestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class UserActionTest extends StrutsSpringTestCase {

    private ActionProxy proxy;
    private UserAction userAction;

    private static final User user;
    private static final String password;

    static {
        password = "pwd";
        user = new User("lily", "女", "Shanghai", "lily.h@fox.com", null, new Date());
    }

    @Before
    public void setUp() throws Exception {
        try {
            super.setUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAddUser() throws Exception {
        request.setAttribute("user", user);
        request.setParameter("password", password);
        request.setParameter("user.name", user.getName());

        proxy = getActionProxy("/user/add");
        userAction = (UserAction) proxy.getAction();

        String result = proxy.execute();
        Assert.assertEquals("success", result);
    }

    @Test
    public void delUser() throws Exception {

    }

}