package com.lzq.spring.util;

import com.lzq.spring.service.Person;
import org.springframework.aop.ClassFilter;

public class MyClassFilter implements ClassFilter {

    // 1.一个接口有多个实现类
    // 2.当前的实现类是不是我们置入方式所关心的目标类
    //  BaseService只管理person
    // 参数就是当前被拦截的类 可能是person 或者dog
    @Override
    public boolean matches(Class<?> clazz) {
        if (clazz == Person.class){
            return true;// 当前类需要置入
        }
        // dog不为dog做置入
        return false;
    }
}
