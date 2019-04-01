package com.lzq.spring;

import static org.junit.Assert.assertTrue;

import com.lzq.config.SpringConfig;
import com.lzq.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
//locations  xml配置文件
//classes Java配置的读取方法
@ContextConfiguration(classes = SpringConfig.class)
public class AppTest 
{

    @Autowired
    private UserService userService;
    @Test
    public void shouldAnswerWithTrue()
    {

        userService.saveUser();
    }



}
