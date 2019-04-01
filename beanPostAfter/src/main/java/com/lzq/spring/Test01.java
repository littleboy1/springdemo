package com.lzq.spring;

import com.lzq.spring.bean.Teacher;
import com.lzq.spring.util.BaseService;
import com.lzq.spring.util.BeanDefined;
import com.lzq.spring.util.BeanFactory;

import java.util.ArrayList;
import java.util.List;

public class Test01 {

    public static void main(String[] args) throws Exception {

        BeanDefined  beanDefined = new BeanDefined();
        beanDefined.setId("iSomeService");
        beanDefined.setClassPath("com.lzq.spring.util.ISomeService");


        BeanDefined  beanDefined2 = new BeanDefined();
        beanDefined2.setClassPath("com.lzq.spring.util.MyBeanPostProcessor");

        List<BeanDefined> beanDefineds = new ArrayList<>();
        beanDefineds.add(beanDefined);  //spring核心配置文件做的事情
        beanDefineds.add(beanDefined2);  //spring核心配置文件做的事情
        //声明一个工厂
        BeanFactory beanFactory = new BeanFactory(beanDefineds);
        // 获取实例对象
        BaseService baseService = (BaseService) beanFactory.getBean("iSomeService");
        System.out.println(baseService.doSome());



    }
}
