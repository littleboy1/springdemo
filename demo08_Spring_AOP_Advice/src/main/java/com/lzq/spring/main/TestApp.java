package com.lzq.spring.main;

import com.lzq.spring.bean.Student;
import com.lzq.spring.bean.Teacher;
import com.lzq.spring.service.BaseService;
import com.lzq.spring.service.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * Bean由spring创建的话bean的所有的生命周期都可以被监控，我们拿到的是spring创建的代理对象
 */
public class TestApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_config.xml");
        BaseService personProxy = (BaseService) applicationContext.getBean("personProxy");
        personProxy.eat();
        personProxy.wc();



    }
}
