package com.ldongxu.designPatterns.dynamicProxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author liudongxu06
 * @since 2019-04-16
 */
public class FangAgent implements MethodInterceptor {

    public Object getInstance(Class clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object proxyObj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("我是房产中介，我帮客户买房子。");
        System.out.println("开始选房子。。。。");
        System.out.println("--------");
        Object obj = methodProxy.invokeSuper(proxyObj,args);
        System.out.println("--------");
        System.out.println("帮客户买到满意的房子");
        return obj;
    }
}
