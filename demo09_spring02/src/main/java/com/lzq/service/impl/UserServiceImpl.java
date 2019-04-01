package com.lzq.service.impl;

import com.lzq.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "userServiceImpl")
public class UserServiceImpl implements UserService {

    @Value("${id}")
    private int id ;

    @Override
    public void saveUser() {
        System.out.println("IOC演示" + id);
    }
}
