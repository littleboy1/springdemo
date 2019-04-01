package com.lzq.spring.util;

import java.util.List;

public class BeanFactory {

    private List<BeanDefined> beanDefineds;

    public List<BeanDefined> getBeanDefineds() {
        return beanDefineds;
    }

    public void setBeanDefineds(List<BeanDefined> beanDefineds) {
        this.beanDefineds = beanDefineds;
    }

    public Object getBean(String beanId) throws Exception {
            Object instance = null;
        for (BeanDefined beanDefined : beanDefineds) {
            if (beanId.equals(beanDefined.getId())){
                String classPath = beanDefined.getClassPath();
                Class classFile = Class.forName(classPath);
                instance =classFile.newInstance();
            }
        }
        return instance;
    }
}
