package com.lzq.spring.util;

public interface BeanPostAfter {

    default Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {

        return bean;
    }
    default Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }
}
