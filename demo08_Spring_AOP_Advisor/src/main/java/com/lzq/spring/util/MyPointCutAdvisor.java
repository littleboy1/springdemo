package com.lzq.spring.util;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;

public class MyPointCutAdvisor implements PointcutAdvisor {

   private Advice advice;  //次要业务次要业务与主要业务的执行顺序

   private Pointcut pointcut; //当前拦截的对象和拦截的方法

    @Override
    public Pointcut getPointcut() {

        return this.pointcut;
    }

    @Override
    public Advice getAdvice() {

        return this.advice;
    }

    @Override
    public boolean isPerInstance() {

        return false;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public void setPointcut(Pointcut pointcut) {
        this.pointcut = pointcut;
    }
}
