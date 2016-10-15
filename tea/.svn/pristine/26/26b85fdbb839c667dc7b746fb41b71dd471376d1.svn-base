package com.mars.tea.springmvc.interceptor;

import static com.mars.tea.springmvc.consts.Strings.SESSION_ATTR_USER;
import static com.mars.tea.springmvc.consts.Strings.SESSION_ATTR_USER_ENTITLED_ELEMENTS;
import static com.mars.tea.springmvc.consts.Strings.SESSION_ATTR_USER_GROUP;
import static com.mars.tea.springmvc.consts.Strings.RAW_SERVLET_REQ_USER_LOGIN_GET;

import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mars.tea.springmvc.annotation.Authentication;
import com.mars.tea.springmvc.annotation.Authorization;
import com.mars.tea.springmvc.enums.ElementTypeE;
import com.mars.tea.springmvc.enums.GroupTypeE;
import com.mars.tea.springmvc.exception.AuthorizationException;
import com.mars.tea.springmvc.service.UserService;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = Logger.getLogger(AuthInterceptor.class);
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
			
			HttpSession session = request.getSession();
			String user = (String) session.getAttribute(SESSION_ATTR_USER);
			
			
			//Authentication below
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			Authentication authentication = method.getAnnotation(Authentication.class);
			//Authentication authentication = ((HandlerMethod) handler).getMethodAnnotation(Authentication.class);
			
			if (authentication != null) {
				if(logger.isDebugEnabled()) {
					logger.debug("---------------------------------Request need to be authenticated]");
				}
				if (null == user) {
					if(logger.isDebugEnabled()) {
						logger.debug("---------------------------------User is not yet log in, will redirect to login page");
					}
					response.sendRedirect(RAW_SERVLET_REQ_USER_LOGIN_GET); //IMPORTANT!!!!!! this wont flow to spring DispatcherServlet
					return false;
				}
				if(logger.isDebugEnabled()) {
					logger.debug("---------------------------------Session [" + session.getId() + "] created at " + session.getCreationTime());
				}
			}
			
			//Authorization below
			Authorization authorization = method.getAnnotation(Authorization.class);
			//Authorization authorization = ((HandlerMethod) handler).getMethodAnnotation(Authorization.class); 
			if(authorization != null) {
				if(logger.isDebugEnabled()) {
					logger.debug("---------------------------------[Request need to be authorized]");
				}
				
				List<GroupTypeE> groups = (List<GroupTypeE>) session.getAttribute(SESSION_ATTR_USER_GROUP);
				List<ElementTypeE> entitledElements = (List<ElementTypeE>) session.getAttribute(SESSION_ATTR_USER_ENTITLED_ELEMENTS);
				
				if(groups == null || entitledElements == null) {
					if(logger.isDebugEnabled()) {
						logger.debug("---------------------------------User is not yet log in, will redirect to login page");
					}
					response.sendRedirect(RAW_SERVLET_REQ_USER_LOGIN_GET); //IMPORTANT!!!!!! this wont flow to spring DispatcherServlet
					return false;
				}
				
				GroupTypeE group = authorization.group();
				ElementTypeE entitlement = authorization.element();
				
				if(!groups.contains(group) || !entitledElements.contains(entitlement)) {
					logger.warn("[NOTICE] [user:" + user + "]" + " is trying to [operation:" + method.getName() + "] without getting entitled !");
					throw new AuthorizationException();
				}
				
				if(logger.isDebugEnabled()) {
					logger.debug("---------------------------------[" + user + " is athorized to access the resource requested]");
				}
			}
		}

		return true;

	}

}
