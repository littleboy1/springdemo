package com.lzq.spring.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("bean 对象初始化之前。。。。。。。");

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class beanType = bean.getClass();
        if (beanType == ISomeService.class) {
            Object $proxy = Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    String result = "";
                    if (method.getName().equals("doSome")) {
                        System.out.println("I some Have bean 拦截");
                        result = (String) method.invoke(bean, args);

                    }
                    return result.toUpperCase();
                }
            });
            return $proxy;
        }
        System.out.println("bean 对象初始化之后--------------");


        return bean;
    }
}
