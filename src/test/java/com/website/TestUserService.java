package com.website;

import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
@Transactional //这个非常关键，如果不加入这个注解配置，事务控制就会完全失效！
//设置事务自动回滚，避免脏数据提交到数据库
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
public class TestUserService extends TestCase {
	/*@Autowired
	private UserService userService;
	@Test
	public void hasMatchUser(){
		boolean b1 = userService.hasMatchUser("admin");
		boolean b2 = userService.hasMatchUser("admin");
		assertTrue(b1);
		//assertTrue(b2); 传进去的为false则会报个null出来表示这个错误结果，并且证明整个流程是错的
	}
	
	@Test
	public void findUserByName(){
		User user = userService.findUserByUserName("admin","123123");
		assertEquals(user.getUserName(), "admin");
	}
	@Test
	public void userLogin(){
		*//*User user = userService.userLogin("admin", "123456");
		userService.LoginSuccess(user);*//*
	}*/
}
