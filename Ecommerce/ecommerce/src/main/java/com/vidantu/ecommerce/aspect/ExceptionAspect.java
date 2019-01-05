package com.vidantu.ecommerce.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;



@Aspect
@Component
@Configuration
@Log4j2
public class ExceptionAspect {

	@AfterThrowing(pointcut = "execution(* com.vidantu.ecommerce..*.*(..))", throwing = "ex")
	public Object logAfterThrowingAllMethods(Exception ex) throws Throwable {
		log.error("**Logged exception is:- " + ex + "** expecption cause is:-" + ex.getMessage());
		return ex;
	}

}
