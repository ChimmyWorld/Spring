package com.itbank.Day76;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itbank.model.AccountDAO;
import com.itbank.model.AccountDTO;
import com.itbank.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml"})
public class AccountTest {
	@Autowired
	private AccountService as; 
	@Autowired
	private AccountDAO dao;
	
	private AccountDTO testAcc;
	
	@Before
	public void setup() {
		testAcc = dao.test(1005);
	}
	
	@Test
	public void ConnectionTest() {
		System.out.println("dao = " + dao);
	}
	
	@Test
	public void selectAllTest() {
		List<AccountDTO> list = dao.selectAll();
		assertNotNull(list);
	}
	
	@Test
	public void loginTest() {
		AccountDTO user;
		
		user = as.login(testAcc);

		assertNotNull(user);
		
		// System.out.println(user.getUserid());
	}
	
}
