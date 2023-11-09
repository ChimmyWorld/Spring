package com.itbank.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RunAOP {
	private long startTime;
	private long endTime;
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Around("execution(* com.itbank.service.*.*(..))")
	public Object runTime(ProceedingJoinPoint jp) throws Throwable {
		startTime = System.currentTimeMillis();
	
		Object result = jp.proceed(jp.getArgs());
	
		endTime = System.currentTimeMillis();
		
		log.trace("시작 시간 : " + startTime);
		log.trace("마친 시간 : " + endTime);
		log.trace("걸린 시간 : " + (endTime - startTime) / 1000.0 +"초 ");
		return result;
	}
}
