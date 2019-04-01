package com.lzq.config;

import com.lzq.service.UserService;
import com.lzq.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"com.lzq"})
@Import(value = {DataConfig.class})
public class SpringConfig {

    public SpringConfig() {
        System.out.println("容易开始创建");
    }



}
