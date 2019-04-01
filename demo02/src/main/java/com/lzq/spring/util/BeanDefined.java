package com.lzq.spring.util;

public class BeanDefined {

    private String id ;

    private String classPath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassPath() {
        return classPath;
    }

    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }

    @Override
    public String toString() {
        return "BeanDefined{" +
                "id='" + id + '\'' +
                ", classPath='" + classPath + '\'' +
                '}';
    }
}
