package com.master.crm.action;

import com.master.crm.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;

public class UserAction extends ActionSupport {

    private static final Logger logger = Logger.getLogger(UserAction.class);

    private UserService userService;

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String addUser() throws Exception {
        logger.info("add user");
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

}
