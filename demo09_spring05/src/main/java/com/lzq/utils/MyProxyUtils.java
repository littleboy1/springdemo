package com.lzq.utils;

import com.lzq.service.UserService;
import com.lzq.service.impl.UserServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxyUtils {


    public static UserService getProxy(UserService service){
        UserService $proxy = (UserService) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("----------动态代理开始----");
                Object object = method.invoke(service,args);
                return object;
            }
        });
        return $proxy;
    }

    public static UserService getProxyByCgLib(UserService service){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(service.getClass()); //此处不可以是接口需要是当前的实现类
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("----------start---------");
                Object methodResult = methodProxy.invokeSuper(o, args);
                System.out.println("----------end---------");
                return methodResult;
            }
        });
        UserService userService = (UserService) enhancer.create();
        return userService;
    }
}
