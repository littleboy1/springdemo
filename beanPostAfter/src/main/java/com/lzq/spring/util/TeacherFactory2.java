package com.lzq.spring.util;

import com.lzq.spring.bean.Teacher;

public class TeacherFactory2 {


    public Teacher createTeacher(){

        Teacher teacher = new Teacher();

        System.out.println("TeacherFactory2222------ Create Teacher");

        return teacher;
    }
}
