package com.ldongxu.learn.guice.inject;

/**
 * Created by 刘东旭 on 2017/7/17.
 */
public class WwwService implements ServiceInterface{
    @Override
    public void execute() {
        System.out.println("I am www implement!");
    }
}
