package com.lzq.spring.util;

import org.springframework.aop.MethodMatcher;

import java.lang.reflect.Method;

public class MyMethodMatcher implements MethodMatcher {
   /*
   *
   *
   * */
    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        String methodName = method.getName();
        if (methodName.equalsIgnoreCase("eat")){
            return true;
        }
        return false;
    }

    @Override
    public boolean isRuntime() {
        return false;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {

        return false;
    }
}
