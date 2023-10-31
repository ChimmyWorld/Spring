package com.itbank.Day75;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itbank.model.BookDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml"})
public class Ex04 {
	@Autowired private BookDAO dao;
	
	@Before
	public void setUp() {
		assertNotNull(dao);
	}
	
	@Test
	public void run1() {
		System.out.println("run1 = " + this);
		System.out.println("dao = " + dao);
		
		// @Test마다 객체가 별도로 생성되어 테스트를 수행
		// 하지만 스프링 빈의 의존성 주입은 그대로 지켜서 테스트 (싱글톤)
	}
	
	@Test
	public void run2() {
		System.out.println("run2 = " + this);
		System.out.println("dao = " + dao);
	}
	
	@Test
	public void run3() {
		System.out.println("run3 = " + this);
		System.out.println("dao = " + dao);
	}
	
	@After
	public void end() {
		System.out.println();
	}
	
}
