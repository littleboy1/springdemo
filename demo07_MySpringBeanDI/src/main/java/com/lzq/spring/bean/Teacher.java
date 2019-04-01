package com.lzq.spring.bean;

import java.util.Arrays;
import java.util.List;

public class Teacher {

    /**
     * DI spring IOC 通过反射机制调用set方法进行赋值处理
     * @return
     */

    private String teacherName;

    private String friendArray[];

    private List<String> school;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String[] getFriendArray() {
        return friendArray;
    }

    public void setFriendArray(Object friendArray) {
        this.friendArray = (String[]) friendArray;
    }

    public List<String> getSchool() {
        return school;
    }

    public void setSchool(List<String> school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherName='" + teacherName + '\'' +
                ", friendArray=" + Arrays.toString(friendArray) +
                ", school=" + school +
                '}';
    }
}
