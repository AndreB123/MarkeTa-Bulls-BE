package com.revature.aspect;

/*
 * LoggingAspect is just to show what methods are being executed so we can keep track of 
 * how our code is running. 
 */
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

	private static final Logger LOG = LogManager.getLogger(LoggingAspect.class);
	
	@Pointcut("execution(public * *(..))")
	public void logAll() {
		
	}
	
	@Pointcut("within(com.revature.service.*)")
	public void logWithinService() {
		
	}
	
	@Before("logAll()")
	public void logBefore(JoinPoint jp) {
		LOG.info("The " + jp.getSignature().getName() + " method is about to be executed.");
	}
	
	@After("logWithinService()")
	public void logAfter(JoinPoint jp) {
		LOG.info("The " + jp.getSignature().getName() + " method was just triggered and its access modifier is " + jp.getSignature().getModifiers());
	}
	
	@AfterReturning(pointcut = "logWithinService()", returning="returnValue")
	public void logAfterReturning(JoinPoint jp, Object returnValue) {
		LOG.info("The " + jp.getSignature().getName() + " method was completed and returned " + returnValue);
	}
}
