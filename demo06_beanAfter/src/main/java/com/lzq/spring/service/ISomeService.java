package com.lzq.spring.service;

public class ISomeService implements BaseService {
    @Override
    public String doSome() {
        return "hello world";
    }
}
