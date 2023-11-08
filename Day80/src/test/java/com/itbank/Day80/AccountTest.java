package com.itbank.Day80;


import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itbank.model.AccountDAO;
import com.itbank.model.vo.AccountDTO;
import com.itbank.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class AccountTest {
	
	@Autowired private AccountDAO dao;
	@Autowired private AccountService as;
	
	private AccountDTO testAcc;
	
	@Before
	public void setup() {
		testAcc = dao.test(1029);
	}
	
	
	@Test
	public void loginTest() {
		AccountDTO user;
		
		user = as.login(testAcc);
		
		assertNotNull(user);
		
		System.out.println(user.getNick());
	}
}
