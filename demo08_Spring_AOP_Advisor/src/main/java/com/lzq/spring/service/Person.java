package com.lzq.spring.service;

import org.springframework.aop.framework.ProxyFactoryBean;

public class Person implements BaseService {
    @Override
    public void eat() { // pointCut 切入点 主要业务方法

        System.out.println("go to eat");

    }

    @Override
    public void wc() {
        System.out.println("go to wc");

    }
}
