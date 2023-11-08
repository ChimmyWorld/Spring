package com.itbank.Day80;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itbank.model.BoardDAO;
import com.itbank.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardTest {
	
	@Autowired private BoardDAO dao;
	@Autowired private BoardService bs;
	
	@Test
	public void daoTest() {
		assertNotNull(bs.getBoards(1));
	}
}
