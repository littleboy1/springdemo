package com.lzq.spring.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class BeanFactory {

    private List<BeanDefined> beanDefineds;
    //已经创建好的容器对象
    private Map<String,Object> SpringIoc = new HashMap<>();

    private BeanPostAfter beanPostAfter; //后置对象

    public List<BeanDefined> getBeanDefineds() {
        return beanDefineds;
    }


    public void setValue (Object instance ,Class classFile,Map propertyMap) throws Exception {
        Method[] declaredMethods = classFile.getDeclaredMethods();
        Set set = propertyMap.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            String fileName = (String) iterator.next();
            String value = (String) propertyMap.get(fileName);
            Field fieldObject = classFile.getDeclaredField(fileName);

            for (Method declaredMethod : declaredMethods) {
                String methodName = "set" + fileName;
                if (methodName.equalsIgnoreCase(declaredMethod.getName())){
                    Class<?> type = fieldObject.getType(); // 判断属性的数据类型
                    if (type == String.class){
                        declaredMethod.invoke(instance,value);
                    }else if(type == Integer.class){
                        declaredMethod.invoke(instance,Integer.valueOf(value));
                    }else if (type == List.class){
                        List tempList = new ArrayList();
                        String[] split = value.split(",");
                        List<String> strings = Arrays.asList(split);
                        tempList.add(strings);
                        declaredMethod.invoke(instance,tempList);
                    }else {
                        String[] split = value.split(",");
                        Object[] objects = new Object[]{split};
                        declaredMethod.invoke(instance,objects);
                    }
                    break;
                }
            }
        }

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
                Map  propertyMap = beanDefined.getPropertyMap();

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
                    setValue(instance,classFile,propertyMap);
                    $proxy = this.beanPostAfter.postProcessAfterInitialization(instance,beanDefined.getId());

                    return $proxy;
                }else {
                    setValue(instance,classFile,propertyMap);
                    return instance;
                }
            }
        }
        return instance;
    }
}
