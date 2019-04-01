package com.lzq.spring.util;

public class ISomeService implements BaseService {
    @Override
    public String doSome() {
        return "hello world";
    }
}
