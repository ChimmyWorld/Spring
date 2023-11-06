package com.itbank.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAOP {
	
	// 지정한 모듈(클래스나 메서드)가 실행되기 전에 먼저 수행")
	@Before("execution(* com.itbank.service.*.*(..))")
	public void start() {
		System.out.println("Before 실행");
	}
		
}
