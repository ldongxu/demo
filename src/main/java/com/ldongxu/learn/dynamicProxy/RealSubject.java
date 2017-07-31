package com.ldongxu.learn.dynamicProxy;

/**
 * Created by 刘东旭 on 2017/6/21.
 */
public class RealSubject implements Subject{
    public void sayHello(String name) {
        System.out.println("Hello "+name);
    }

    public void rent() {
        System.out.println("I want to go home.");
    }
}
