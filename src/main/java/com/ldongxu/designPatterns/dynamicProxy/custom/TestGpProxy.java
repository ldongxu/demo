package com.ldongxu.designPatterns.dynamicProxy.custom;

/**
 * @author liudongxu06
 * @since 2019-04-16
 */
public class TestGpProxy {

    public static void main(String[] args) {

        //动态代理原理
        //1、拿到被代理对象的引用，获取它的接口
        //2、Jdk代理重新生成一个类，同时实现代理对象的接口
        //3、把代理对象引用拿到
        //4、重新动态生成一个class字节码
        //5、然后编译
        //6、加载到jvm

        GpPerson person = (GpPerson) new GpMeipo().getInstance(new XiaoWang());
        person.findLove();
    }
}
