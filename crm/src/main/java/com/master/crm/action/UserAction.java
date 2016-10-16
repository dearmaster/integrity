package com.master.crm.action;

import com.master.crm.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;

public class UserAction extends ActionSupport implements ServletRequestAware {

    private static final Logger logger = Logger.getLogger(UserAction.class);

    private UserService userService;

    private HttpServletRequest request;

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String addUser() throws Exception {
        logger.info(this);
        logger.info(request.getSession().getId() + " - add user");
        return SUCCESS;
    }

    public String delUser() throws Exception {
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
}
