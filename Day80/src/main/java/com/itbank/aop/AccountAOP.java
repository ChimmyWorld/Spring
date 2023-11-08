package com.itbank.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itbank.component.SHA512;
import com.itbank.model.vo.AccountDTO;

@Aspect
@Component
public class AccountAOP {
	@Autowired private SHA512 hash;
	
	// @Around: 지정 메서드 실행 전/후로 모두 수행
	
	@Around("execution(* com.itbank.service.AccountService.*(..))")
	public Object hash(ProceedingJoinPoint jp) throws Throwable {
		// before 
		AccountDTO input = (AccountDTO)jp.getArgs()[0];
		System.out.println("해시 전 " + input.getUserpw());
		
		input.setUserpw(hash.getHash(input.getUserpw()));
		
		// 지정 메서드 실행
		Object result = jp.proceed(jp.getArgs());
		
		// after
		System.out.println("해시 후 " + input.getUserpw());
		
		return result;
	}
}
