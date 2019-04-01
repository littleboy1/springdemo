package com.lzq.spring.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanFactory {

    private List<BeanDefined> beanDefineds;
    //已经创建好的容器对象
    private Map<String,Object> SpringIoc = new HashMap<>();

    public List<BeanDefined> getBeanDefineds() {
        return beanDefineds;
    }

    public BeanFactory(List<BeanDefined> beanDefineds) throws Exception {
        this.beanDefineds = beanDefineds;
        for (BeanDefined beanDefined : beanDefineds) {
            if ("singleton".equals(beanDefined.getScope())){
                Class classFile = Class.forName(beanDefined.getClassPath());
                Object instance = classFile.newInstance();
                SpringIoc.put(beanDefined.getId(),instance);
            }
        }
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
                String scope = beanDefined.getScope();
                if (scope.equals("singleton")){
                    instance = SpringIoc.get(beanDefined.getId());
                }else {
                    instance = classFile.newInstance();
                }
            }
        }
        return instance;
    }
}
