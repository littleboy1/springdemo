package com.lzq.spring;

import com.lzq.spring.bean.Teacher;
import com.lzq.spring.util.BaseService;
import com.lzq.spring.util.BeanDefined;
import com.lzq.spring.util.BeanFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test01 {

    public static void main(String[] args) throws Exception {

        BeanDefined  beanDefined = new BeanDefined();
        beanDefined.setId("teacher");
        beanDefined.setClassPath("com.lzq.spring.bean.Teacher");
        Map<String, String> propertyMap = beanDefined.getPropertyMap();
        propertyMap.put("teacherName","李老师");
        propertyMap.put("friendArray","老刘,老孙,小师妹");
        propertyMap.put("school","北京,伤害大学");
        List configuration = new ArrayList();
        configuration.add(beanDefined);
        BeanFactory factory = new BeanFactory(configuration);
        Teacher teacher = (Teacher) factory.getBean("teacher");
        System.out.println("t=" + teacher);




    }
}
