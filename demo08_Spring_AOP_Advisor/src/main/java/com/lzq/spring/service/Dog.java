package com.lzq.spring.service;

public class Dog implements BaseService {
    @Override
    public void eat() {
        System.out.println("坑骨头");
    }

    @Override
    public void wc() {
        System.out.println("嘘嘘");
    }
}
