package com.lzq.service.impl;

import com.lzq.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "userService")
//@Scope(value = "prototype")
@Scope(value = "singleton")
@PropertySource(value = "data.properties")
public class UserServiceImpl implements UserService {


    @Value("${id}")
    private int id ;

    @Override
    public void saveUser() {
        System.out.println("IOC演示" + id);
    }
}
