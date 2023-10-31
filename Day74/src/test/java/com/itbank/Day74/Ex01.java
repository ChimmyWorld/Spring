package com.itbank.Day74;

import org.junit.Test;

public class Ex01 {
	
	// @Test
	// - junit이 실행할 메서드로 등록
	// - 반환형은 항상 void로 지정
	@Test
	public void test1() {
		System.out.println(10/ 0);
		
		System.out.println(this);
		System.out.println("1. hello");
	}
	
	// @Test는 위에서부터 순서대로 수행
	// @Test마다 클래스(Ex01)이 별도로 생성된다
	// - 다른 테스트에 영향을 주지 않기 위함 
	@Test
	public void test2() {
		System.out.println(this);
		System.out.println("2. 두번째 메서드 ");
	}
	
}