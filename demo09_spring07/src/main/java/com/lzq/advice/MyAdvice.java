package com.lzq.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {

    public void log(){
        System.out.println("I am a advice before");
    }

    public void log1(){
        System.out.println("I am a advice after returning");
    }

    public void log2(){
        System.out.println("I am a advice after");
    }
    public void log3(){
        System.out.println("I am a advice throw exception");
    }

    public void log4(){
        System.out.println("I am a advice around");
    }
    // this is about around advise ,it always using in transaction
    public void log5(ProceedingJoinPoint joinPoint){
        System.out.println("I am a advice when the method invokes around before" );
        // invoke the target method
        try {
            Object o = joinPoint.proceed();
            System.out.println("I am after returning");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("I am after-throwing");
        }finally {
            System.out.println("I am a advice in the finally code segment" );
        }

    }
}
