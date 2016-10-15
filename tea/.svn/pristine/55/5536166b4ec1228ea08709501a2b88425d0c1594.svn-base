package com.mars.tea.springmvc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.mars.tea.springmvc.pojo.User;
import com.mars.tea.springmvc.pojo.Credential;

/**
 * Extends AbstractTransactionalJUnit4SpringContextTests, then the transaction
 * will rollback after the test. No other config needed, just extend it.
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:/applicationContext.xml"}) 
public class UserControllerTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	private static final Logger logger = Logger.getLogger(UserControllerTest.class);
	
	private static final String POST = "post";
	private static final String GET = "get";
	
	private MockHttpServletRequest request;  
    private MockHttpServletResponse response;
    
    @Autowired
    private UserController controller;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
        request = new MockHttpServletRequest();      
        //request.setCharacterEncoding("UTF-8");      
        response = new MockHttpServletResponse(); 
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLoginGet() {
	}

	/**
	 * @Transactional(propagation=Propagation.NOT_SUPPORTED)用来取消外部事务
	 * 只用service自己的事务，所以执行完后测试数据会保留在数据库中
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	@Test
	@Ignore
	public void testRegisterGet() {
		request.setMethod(POST);
		Date birthday = null;
		try {
			birthday = new SimpleDateFormat("yyyy-MM-dd").parse("1998-11-20");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		User user = new User("Lily.T", "女", "lily.t@163.com", "28382923", "上海", birthday);
		Credential credential = new Credential("lily", "abc");
		
		//change(user, credential);
		
		if(user != null && credential != null) {
			ModelAndView mav = controller.registerPost(user, credential, request);
			logger.info(mav.getViewName());
		}
	}
	
	void change(User user, Credential credential) {
		long time = new Date().getTime();
		user.setPhone(user.getMail()+ time);
		credential.setUserName(credential.getUserName() + time);
	}
	
	//@Ignore
	@Test
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public void testDeleteUserPost() {
		String username = "lily";
		request.setMethod(POST);
		request.setParameter("username", username);
		ModelAndView mav = controller.deleteUserPost(request, response);
		logger.info(mav.getViewName());
	}

	@Test
	public void testDeleteAdmin() {
	}

	@Test
	public void testLoginPost() {
	}

	@Test
	public void testRegisterPost() {
	}

}
