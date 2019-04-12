package com.ldongxu.designPatterns.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 刘东旭 on 2017/6/21.
 */
public class DynamicProxy implements InvocationHandler{

    private Subject subject;

    public DynamicProxy(Subject subject) {
        this.subject = subject;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        method.invoke(subject,args);
        System.out.println("after");
        return null;
    }

    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        InvocationHandler handler = new DynamicProxy(realSubject);
        Subject subject = (Subject) Proxy.newProxyInstance( RealSubject.class.getClassLoader(),RealSubject.class.getInterfaces(),handler);
        subject.sayHello("liudongxu");
    }
}
