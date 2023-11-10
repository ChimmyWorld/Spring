package com.itbank.Day82;

import org.junit.Test;

public class StringTest {
	@Test
	public void ex01() { 
		String file = "페.이.징.txt";
		
		int dot = file.indexOf(".");
		int dotBack = file.lastIndexOf(".");
		
		System.out.println("file = " + file);
		System.out.println("file = " + file.charAt(0));
		System.out.println("file = " + dot);
		System.out.println("file = " + file.substring(dot));
		System.out.println("file = " + dotBack);
		System.out.println("file = " + file.substring(dotBack));
	}
}
