package com.lzq.spring.util;

public class BeanDefined {

    private String id ;

    private String classPath;

    private String scope = "singleton";

    private String factoryBean;

    private String factoryMethod;

    public String getFactoryBean() {
        return factoryBean;
    }

    public void setFactoryBean(String factoryBean) {
        this.factoryBean = factoryBean;
    }

    public String getFactoryMethod() {
        return factoryMethod;
    }

    public void setFactoryMethod(String factoryMethod) {
        this.factoryMethod = factoryMethod;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

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
                ", scope='" + scope + '\'' +
                ", factoryBean='" + factoryBean + '\'' +
                ", factoryMethod='" + factoryMethod + '\'' +
                '}';
    }
}
