package com.lzq.spring;

import com.lzq.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:Spring_config1.xml")
public class TestAOP {


    @Autowired
    private UserService service;

    @Test
    public void test1(){
        service.saveUser();
    }
}
