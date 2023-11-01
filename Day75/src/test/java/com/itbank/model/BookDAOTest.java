package com.itbank.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itbank.model.BookDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src\\main\\webapp\\WEB-INF\\spring\\root-context.xml"})
public class BookDAOTest {
	
	@Autowired
	private BookDAO dao;
	
	@Test
	@Ignore	// 테스트를 위해 작성했지만 이후 테스트에서 제외하고 싶은 경우 사용
	public void connectionTest() {
		System.out.println("dao = " + dao);
		System.out.println("banner = " + dao.test());
	}
	
	@Test
	public void selectAllTest() {
		Map<String, Object> param = new HashMap<>();
		param.put("type","title");
		param.put("search", "");
		
		List<BookDTO> list = dao.selectAll(param);
		
		assertNotNull(list);
	}
	
	// 테스트에서 호출해서 사용하는 메서드도 작성가능
	// 테스트 실행시 @Test 어노테이션이 붙은 것만 프레임워크가 실행
	private BookDTO setField() {
		BookDTO input = new BookDTO();
		Date date = Date.valueOf("2023-05-05");
		
		input.setP_date(date);
		input.setPrice(10000);
		input.setPublisher("tesdd");
		input.setTitle("test");
		input.setWriter("test");
		
		return input;
	}
	
	@Test 
	@Ignore
	public void insertTest() {
		BookDTO input = setField();
		
		int row = dao.insert(input);
		
		assertNotEquals(0, row);
	}
	
	@Test
	public void selectOneTest() {
		BookDTO row = dao.selectOne(1000);
		
		assertNotNull(row);
		
		System.out.println(row);
	}
	
	@Test 
	public void updateTest() {
		BookDTO input = setField();
		input.setIdx(1000);
		input.setTitle("수정테스트");
		
		int row = dao.update(input);
		assertNotEquals(0, row);
	}
	
	@Test 
	@Ignore
	public void deleteTest() {
		int row = dao.delete(1031);
		assertNotEquals(0, row);
	}

}
