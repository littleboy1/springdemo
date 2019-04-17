package com.lzq.service.impl;

import com.lzq.service.UserService;
import org.springframework.stereotype.Component;


@Component(value = "userServiceImpl")
public class UserServiceImpl implements UserService {


    @Override
    public void saveUser() {

        System.out.println("IOC演示" );
//        System.out.println(1/0);
    }



}
