package com.lzq.utils;

import com.lzq.service.UserService;
import com.lzq.service.impl.UserServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {

    public static void main(String[] args){

        UserService service1 = new UserServiceImpl();

//        UserService service2 = MyProxyUtils.getProxy(service1);
//
//        service1.saveUser();
//
//        service2.saveUser();
//        UserService service2 = MyProxyUtils.getProxyByCgLib(service1);
//        service2.saveUser();

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("Spring_config1.xml");
        UserService bean = classPathXmlApplicationContext.getBean(UserService.class);
        bean.saveUser();

    }
}
