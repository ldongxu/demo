package com.ldongxu.learn.guice.inject;

/**
 * Created by 刘东旭 on 2017/7/13.
 */
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String sayHello() {
        return "hello world!";
    }
}
