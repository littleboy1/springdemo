package com.lzq.spring;

import com.lzq.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:Spring_annocation.xml")
public class AccoutServiceTest {


    @Autowired
    private AccountService accountService;



    @Test
    public void test1(){
        accountService.transfer("老公","老婆",100);

    }

}
