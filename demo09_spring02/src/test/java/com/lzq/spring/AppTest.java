package com.lzq.spring;

import static org.junit.Assert.assertTrue;

import com.lzq.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void shouldAnswerWithTrue()
    {

    }

    @Test
    public void test01()
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring_config.xml");
        UserService userServiceImpl1 = (UserService) applicationContext.getBean("userServiceImpl");
        userServiceImpl1.saveUser();
        UserService bean = applicationContext.getBean(UserService.class);
        bean.saveUser();
    }
}
