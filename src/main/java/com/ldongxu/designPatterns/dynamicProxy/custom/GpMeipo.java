package com.ldongxu.designPatterns.dynamicProxy.custom;

import java.lang.reflect.Method;

/**
 * @author liudongxu06
 * @since 2019-04-16
 */
public class GpMeipo implements GpInvocationHandler {

    private GpPerson target;

    public Object getInstance(GpPerson gpPerson){
        this.target= gpPerson;
        return GpProxy.newProxyInstance(new GpCassLoader(),gpPerson.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method proxyMethod, Object[] args) throws Throwable {
        System.out.println("我是媒婆。");
        System.out.println("我要帮"+target.getName()+"找对象，你的性别是："+target.getSex()+"。");
        System.out.println("开始进行海选......");
        System.out.println("------------");
        Object object = proxyMethod.invoke(target,args);
        System.out.println("------------");
        System.out.println("终于找到了合适的对象。");
        return object;
    }
}
