package com.ldongxu.designPatterns.dynamicProxy.cglib;

/**
 * @author liudongxu06
 * @since 2019-04-16
 */
public class TestCglibProxy {

    public static void main(String[] args) {
        FangBuyer buyer = (FangBuyer) new FangAgent().getInstance(FangBuyer.class);
        buyer.buyHome();
    }
}
