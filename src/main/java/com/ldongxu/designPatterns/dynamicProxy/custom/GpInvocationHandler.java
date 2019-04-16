package com.ldongxu.designPatterns.dynamicProxy.custom;

import java.lang.reflect.Method;

/**
 * @author liudongxu06
 * @since 2019-04-16
 */
public interface GpInvocationHandler {

    Object invoke(Object proxy, Method proxyMethod,Object[] args) throws Throwable;
}
