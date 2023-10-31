package com.itbank.Day75;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.itbank.model.BookDAO;
import com.itbank.model.BookDTO;

public class Ex03 {
	private int[] arr1, arr2; 
	private BookDTO b1, b2, b3;
	
	@Before
	public void setUp() {
		arr1 = new int[] { 10, 20, 30 };
		arr2 = new int[] { 10, 20, 30 };
		
		b1 = new BookDTO();
		b2 = new BookDTO();
		b3 = b1;
		
		b1.setIdx(100);
		b2.setIdx(100);
	}
	
	@Test
	public void ex01() {	
		assertArrayEquals(arr1, arr2); 	// 두 배열의 요소가 일치하는지 판별
		System.out.println("실행 완료"); 	// 기대값이 맞으면 그대로 이어서 메서드 수행
	}
	
	@Test
	public void ex02() {
		arr2[2] = 33;
		
		assertArrayEquals(arr1, arr2);	// 기대값이 아니면 failure를 발생시킨다
		System.out.println("실행?");		// 발생 후의 코드는 실행되지 않는다
	}
	
	@Test
	public void ex03() {
		assertNotEquals(arr1[0], arr2[1]); // 두 데이터(값)가 같지 않으면 성공
		
		assertNotEquals(b1, b2);		// Class는 equals를 구현해야 제대로 비교됨
	}
	
	@Test
	public void ex04() {
		System.out.println("\nb1 = " + b1);
		System.out.println("b2 = " + b2);
		System.out.println("b3 = " + b3);
		
		assertSame(b1, b3);				// 두 참조 변수의 참조 대상이 같아야 성공
		
		assertNotSame(b1, b2);			// 다르면 성공
	}
	
	@Test
	public void ex05() {
		b3 = null;
		
		assertNotNull(b1);
		assertNull(b3);
		assertTrue(10 >= 5);
		assertFalse(10 != 10);
	}
	
}
