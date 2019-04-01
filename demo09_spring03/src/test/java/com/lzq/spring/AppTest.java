package com.lzq.spring;

import static org.junit.Assert.assertTrue;

import com.lzq.config.SpringConfig;
import com.lzq.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
       ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserService bean = context.getBean(UserService.class);
//        UserService bean2 = (UserService) context.getBean("userService");
////        System.out.println(bean == bean2);
        bean.saveUser();
    }
}
