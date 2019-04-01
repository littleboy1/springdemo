package com.lzq.spring.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanFactory {

    private List<BeanDefined> beanDefineds;
    //已经创建好的容器对象
    private Map<String,Object> SpringIoc = new HashMap<>();

    private BeanPostAfter beanPostAfter; //后置对象

    public List<BeanDefined> getBeanDefineds() {
        return beanDefineds;
    }

    public BeanFactory(List<BeanDefined> beanDefineds) throws Exception {
        this.beanDefineds = beanDefineds;
        for (BeanDefined beanDefined : beanDefineds) {
            if ("singleton".equals(beanDefined.getScope())){
                Class classFile = Class.forName(beanDefined.getClassPath());
                Object instance = classFile.newInstance();
                  if (isProcessor(classFile)){
                      beanPostAfter = (BeanPostAfter) instance;
                  }

                SpringIoc.put(beanDefined.getId(),instance);
            }
        }
    }

    private boolean isProcessor(Class classFile){
        Class[] interfaces = classFile.getInterfaces();
        if (interfaces == null){
            return false;
        }else {
            for (Class anInterface : interfaces) {
                if (anInterface == BeanPostAfter.class){
                    return true;
                }
            }
        }
        return false;
    }

    public void setBeanDefineds(List<BeanDefined> beanDefineds) {
        this.beanDefineds = beanDefineds;
    }

    public Object getBean(String beanId) throws Exception {
            Object instance = null;
            Object $proxy = null;
        for (BeanDefined beanDefined : beanDefineds) {
            if (beanId.equals(beanDefined.getId())){
                String classPath = beanDefined.getClassPath();
                Class classFile = Class.forName(classPath);
                String scope = beanDefined.getScope();
                String factory = beanDefined.getFactoryBean();
                String factoryMethod = beanDefined.getFactoryMethod();

                if (scope.equals("singleton")){
                    instance = SpringIoc.get(beanDefined.getId());

                }else {
                    if (factory != null && factoryMethod != null){
                        Object factoryObject = SpringIoc.get(factory);
                        Class factoryClass = factoryObject.getClass();
                        Method methodobj = factoryClass.getDeclaredMethod(factoryMethod,null);
                        methodobj.setAccessible(true);
                        instance = methodobj.invoke(factoryObject,null);
                    }else {
                        instance = classFile.newInstance();
                    }
                }
                if (this.beanPostAfter != null){
                    $proxy = this.beanPostAfter.postProcessBeforeInitialization(instance,beanDefined.getId());

                    $proxy = this.beanPostAfter.postProcessAfterInitialization(instance,beanDefined.getId());

                    return $proxy;
                }else {
                    return instance;
                }
            }
        }
        return instance;
    }
}
