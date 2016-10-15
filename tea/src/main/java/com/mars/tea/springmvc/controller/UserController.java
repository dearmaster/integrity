package com.mars.tea.springmvc.controller;

import static com.mars.tea.springmvc.consts.Strings.SESSION_ATTR_USER;
import static com.mars.tea.springmvc.consts.Strings.SESSION_ATTR_USER_ENTITLED_ELEMENTS;
import static com.mars.tea.springmvc.consts.Strings.SESSION_ATTR_USER_GROUP;
import static com.mars.tea.springmvc.consts.Strings.VIEW_USER_INCORRECT_PASSWORD;
import static com.mars.tea.springmvc.consts.Strings.VIEW_USER_LOGIN;
import static com.mars.tea.springmvc.consts.Strings.VIEW_USER_LOGIN_SUCCESS;
import static com.mars.tea.springmvc.consts.Strings.VIEW_USER_NOT_EXISTS;
import static com.mars.tea.springmvc.consts.Strings.VIEW_USER_REGISTER;
import static com.mars.tea.springmvc.consts.Strings.VIEW_USER_REGISTER_FAILED;
import static com.mars.tea.springmvc.consts.Strings.VIEW_USER_REGISTER_SUCCESS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mars.tea.springmvc.annotation.Authorization;
import com.mars.tea.springmvc.enums.ElementTypeE;
import com.mars.tea.springmvc.enums.GroupTypeE;
import com.mars.tea.springmvc.pojo.Credential;
import com.mars.tea.springmvc.pojo.Element;
import com.mars.tea.springmvc.pojo.User;
import com.mars.tea.springmvc.service.CredentialService;
import com.mars.tea.springmvc.service.ElementService;
import com.mars.tea.springmvc.service.GroupService;
import com.mars.tea.springmvc.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	@Autowired
	@Qualifier("credentialService")
	private CredentialService credentialService;
	@Autowired
	@Qualifier("elementService")
	private ElementService elementService;
	@Autowired
	@Qualifier("groupService")
	private GroupService groupService;
	
	@RequestMapping(method=RequestMethod.GET, value="login")
	public String loginGet() {
		return VIEW_USER_LOGIN;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="register")
	public ModelAndView registerGet() {
		return new ModelAndView(VIEW_USER_REGISTER);
	}	
	
	@Authorization(group=GroupTypeE.ADMIN)
	@RequestMapping(method=RequestMethod.GET, value="deleteUser")
	public ModelAndView deleteUserGet(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("WEB-INF/error/success");
	}
	
	@Authorization(group=GroupTypeE.SUPER_ADMIN)
	@RequestMapping(method=RequestMethod.GET, value="deleteAdmin")
	public ModelAndView deleteAdmin(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("WEB-INF/error/success");
	}
	
	@RequestMapping(method=RequestMethod.POST, value="login")
	public ModelAndView loginPost(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		Credential credential = credentialService.getCredential(username);
		
		if(credential == null) {
			if(logger.isDebugEnabled()) {
				logger.debug("---------------------------------[" + username + " can't be found in db]");
			}
			return new ModelAndView(VIEW_USER_NOT_EXISTS);
		} else if(!credential.getPassWord().equals(password)) {
			if(logger.isDebugEnabled()) {
				logger.debug("---------------------------------[Incorrect password for " + username);
			}
			return new ModelAndView(VIEW_USER_INCORRECT_PASSWORD);
		}
		
		if(logger.isDebugEnabled()) {
			logger.debug("---------------------------------[" + username + " login success]");
		}
		
		HttpSession session = request.getSession();
		List<GroupTypeE> groupTypes = groupService.getGroups(username);
		List<ElementTypeE> entitledElementTypes = elementService.getEntitledElements(username);
		
		List<String> groups = new ArrayList<>();
		List<String> entitledElements = new ArrayList<>();
		if(groupTypes != null && groupTypes.size() > 0) {
			for(GroupTypeE group : groupTypes) {
				groups.add(group.name());
			}
		}
		if(entitledElementTypes != null && entitledElementTypes.size() > 0) {
			for(ElementTypeE element : entitledElementTypes) {
				entitledElements.add(element.name());
			}
		}
		
		session.setAttribute(SESSION_ATTR_USER, username);
		session.setAttribute(SESSION_ATTR_USER_GROUP, groups);
		session.setAttribute(SESSION_ATTR_USER_ENTITLED_ELEMENTS, entitledElements);
		return new ModelAndView(VIEW_USER_LOGIN_SUCCESS);
		
	}
	
	@Authorization(group=GroupTypeE.ADMIN)
	@RequestMapping(method=RequestMethod.POST, value="deleteUser")
	public ModelAndView deleteUserPost(HttpServletRequest request, HttpServletResponse response) {
		if(logger.isDebugEnabled()) {
			logger.debug("----------------post delete User...");
		}
		String username = request.getParameter("username");
		boolean result = credentialService.deleteByUserName(username);
		if(result)
			return new ModelAndView("WEB-INF/error/success");
		return new ModelAndView("WEB-INF/error/delete_user_fail");
	}
	
	@RequestMapping(method=RequestMethod.POST, value="register")
	public ModelAndView registerPost(User user, Credential credential, HttpServletRequest request) {
		user.setCredential(credential);
		credential.setUser(user);
		if(logger.isDebugEnabled()) {
			logger.debug(credential);
			logger.debug(user);
		}
		Credential persistCredential = credentialService.register(credential);
		if(persistCredential != null)
			return new ModelAndView(VIEW_USER_REGISTER_SUCCESS);
		return new ModelAndView(VIEW_USER_REGISTER_FAILED);
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST, value="getElements", consumes=MediaType.APPLICATION_JSON_VALUE)
	public Set<Element> getIntitledElements(@RequestBody Credential credential) {
		Set<Element> set = new HashSet<Element>();
		for(int i=1; i<=10; i++) {
			Element element = new Element();
			element.setName("name " + i);
			set.add(element);
		}
		logger.info(set.size()+ "----------------------------------------------");
		return set;
	}
	

}
