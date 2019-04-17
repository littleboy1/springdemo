package com.lzq.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component("myAspect")
public class MyAspect {

    private static final String str = "execution(* *..*.*ServiceImpl.*(..))";
    @Before(value = "fn()")
    public void before(){
        System.out.println("注解前置通知");
    }

    @After(value = "fn()")
    public void after(){
        System.out.println("后置通知");
    }

    @AfterReturning(value = "execution(* *..*.*ServiceImpl.*(..))")
    public void AfterReturning(){
        System.out.println("最终通知");
    }

    @AfterThrowing(value = "execution(* *..*.*ServiceImpl.*(..))")
    public void AfterThrowing(){
        System.out.println("异常通知");
    }


    @Pointcut(str)
    public void  fn(){}



}
