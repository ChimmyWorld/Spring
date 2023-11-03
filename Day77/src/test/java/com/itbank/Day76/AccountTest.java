package com.itbank.Day76;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itbank.components.SHA512;
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
	@Autowired
	private SHA512 hash;
	
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
		
		user = dao.selectOne(testAcc);

		assertNotNull(user);
		
		// System.out.println(user.getUserid());
	}
	
	@Test // delete/insert 테스트 동시에 진행
	@Ignore
	public void signUpTest() throws NoSuchAlgorithmException {
		testAcc.setUserid("testCase123123");
		testAcc.setNick("테스트시 삭제 후 진행");
		
		AccountDTO delAcc = dao.selectOne(testAcc);
		
		// 1. 계정이 있으면 제거 후
		if (delAcc != null) {
			int row = as.deleteAccounts(delAcc.getIdx());
			assertNotEquals(0, row);
		}
		
		// 2. insert를 수행
		int row = as.signUp(testAcc);
		assertNotEquals("이미 있는 계정", 0, row);
	}
	
	@Test
	public void testGetHash() throws NoSuchAlgorithmException {
		String testPw = "4dff4ea340f0a823f15d3f4f01ab62eae0e5da579ccb851f8db9dfe84c58b2b37b89903a740e1ee172da793a6e79d560e5f7f9bd058a12a280433ed6fa46510a";
		
		assertEquals(testPw, hash.getHash("1"));
	}
	
	@Test
	public void findId() {
		String input = "uptest@naver.com";
		
	}
}
