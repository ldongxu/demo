package com.ldongxu.learn.guice.inject;

/**
 * Created by 刘东旭 on 2017/7/17.
 */
public class ServiceImpl implements Service {
    @Override
    public void execute() {
        System.out.println("This is made by imxylz (www.imxylz.cn).");
    }
}
