package com.ldongxu.learn.guice.inject;

import com.google.inject.Singleton;

/**
 * Created by 刘东旭 on 2017/7/13.
 */
@Singleton
public class HelloWoldService {
    public void testSingletonInject(){
        System.out.println("I am inject to.");
    }
}
