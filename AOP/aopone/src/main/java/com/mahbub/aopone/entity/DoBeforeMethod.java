package com.mahbub.aopone.entity;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

public class DoBeforeMethod implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice, MethodInterceptor {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("DoBeforeMethod : Executing before method!");
    }

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("DoBeforeMethod : Executing After method!");
    }


    public void afterThrowing(IllegalArgumentException e) throws Throwable {
        System.out.println("DoAfterThrowingExceptionMethod : Executing when method throws exception!");

    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("DoAroundMethod: Method name: " + methodInvocation.getMethod().getName());
        System.out.println("DoAroundMethod: Method arguments: " + Arrays.toString(methodInvocation.getArguments()));
        System.out.println("DoAroundMethod: Before method executing!");

        try {
            Object result = methodInvocation.proceed();
            System.out.println("DoAroundMethod: After method executing!");
            return result;
        } catch (IllegalArgumentException e) {
            System.out.println("DoAroundMethod: When method throws Exception!");
            throw e;


        }

    }
}
