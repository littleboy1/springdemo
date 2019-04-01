package com.lzq.spring;

import com.lzq.spring.bean.Teacher;
import com.lzq.spring.util.BeanDefined;
import com.lzq.spring.util.BeanFactory;

import java.util.ArrayList;
import java.util.List;

public class Test01 {

    public static void main(String[] args) throws Exception {

        BeanDefined  beanDefined = new BeanDefined();
        beanDefined.setId("teacher");
        beanDefined.setClassPath("com.lzq.spring.bean.Teacher");
        beanDefined.setScope("prototype");
        beanDefined.setFactoryBean("teacherFactory");
        beanDefined.setFactoryMethod("createTeacher");
        BeanDefined  beanDefined2 = new BeanDefined();
        beanDefined2.setId("teacherFactory");
        beanDefined2.setClassPath("com.lzq.spring.util.TeacherFactory2");

        List<BeanDefined> beanDefineds = new ArrayList<>();
        beanDefineds.add(beanDefined);  //spring核心配置文件做的事情
        beanDefineds.add(beanDefined2);  //spring核心配置文件做的事情
        //声明一个工厂
        BeanFactory beanFactory = new BeanFactory(beanDefineds);
        // 获取实例对象
        Teacher teacher = (Teacher) beanFactory.getBean("teacher");
        System.out.println(teacher);



    }
}
