package com.mindtree.utility;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspects {
	@Autowired
	Environment ev;
	
	 final Logger log=Logger.getLogger(LoggingAspects.class);
	@AfterThrowing(pointcut = "execution(* com.mindtree.service.*Impl.*(..))",throwing = "ex")
	public void serviceException(JoinPoint jp, Throwable ex)
	{
		
		log.error(ev.getProperty(ex.getMessage(),ex.getMessage()));
	}
	@AfterThrowing(pointcut = "execution(* com.mindtree.repository.*Impl.*(..))",throwing = "ex")
	public void repositoryException(JoinPoint jp, Throwable ex)
	{
		log.error(ev.getProperty(ex.getMessage(),ex.getMessage()));
	}

}
