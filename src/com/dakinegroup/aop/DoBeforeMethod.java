package com.dakinegroup.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class DoBeforeMethod implements MethodBeforeAdvice {

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("***SPRINT AOP: DoBeforeMethod: Executing before method");
	}

}
