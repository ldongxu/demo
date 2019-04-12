package com.ldongxu.designPatterns.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author liudongxu06
 * @since 2019-04-12
 */
public class Meipo implements InvocationHandler {

    private Person target;

    public Object getInstance(Person target){
        this.target = target;
        Class clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是媒婆。");
        System.out.println("我要帮"+target.getName()+"找对象，你的性别是："+target.getSex()+"。");
        System.out.println("开始进行海选......");
        System.out.println("------------");
        Object object = method.invoke(target,args);
        System.out.println("------------");
        System.out.println("终于找到了合适的对象。");
        return object;
    }
}
