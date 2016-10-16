package com.master.crm.action;

import com.master.crm.model.User;
import com.master.crm.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;

public class UserAction extends ActionSupport implements ServletRequestAware {

    private static final Logger logger = Logger.getLogger(UserAction.class);

    private UserService userService;

    private User user;

    private String password;

    private HttpServletRequest request;

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String addUser() throws Exception {
        userService.add(user, password);
        return SUCCESS;
    }

    public String delUser() throws Exception {
        userService.del(user);
        return SUCCESS;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
