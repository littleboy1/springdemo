package com.lzq.spring.factory;

import com.lzq.spring.bean.Teacher;


public class TeacherFactory {


    public static Teacher createTeacher(){

        Teacher teacher = new Teacher();

        System.out.println("TeacherFactory Create Teacher");



        return teacher;
    }
}
