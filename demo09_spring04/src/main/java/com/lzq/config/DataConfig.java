package com.lzq.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DataConfig {

    public DataConfig() {

        System.out.println("我已经被加载了");
    }
}
