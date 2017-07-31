package com.ldongxu.learn.guice.inject;

import com.google.inject.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by 刘东旭 on 2017/7/13.
 */
public class HelloWorld_Test {
    @Inject
    private Service service;

    @Inject
    private static Service service2;

    @Inject
    @Home
    private ServiceInterface serviceInterface;

    @Inject
    @Www
    private ServiceInterface serviceInterface1;

    @Test
    public void test1() {
        Injector injector = Guice.createInjector(new Module() {
            public void configure(Binder binder) {
                binder.bind(HelloWorld.class).to(HelloWorldImpl.class);
            }
        });
        HelloWorld hw = injector.getInstance(HelloWorld.class);
        System.out.println(hw.sayHello());
        Assert.assertEquals(hw.sayHello(),"hello world!");
    }

    @Test
    public void test2(){
        Injector injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(HelloWorld.class).toInstance(new HelloWorldImpl());
            }
        });
        HelloWorld hw = injector.getInstance(HelloWorld.class);
        System.out.println(hw.sayHello());
    }

    @Test
    public void test3(){
        Injector injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(HelloWorld.class).toProvider(new Provider<HelloWorld>() {
                    @Override
                    public HelloWorld get() {
                        return new HelloWorldImpl();
                    }
                });
            }
        });
        HelloWorld hw = injector.getInstance(HelloWorld.class);
        System.out.println(hw.sayHello());
    }

    @Test
    public void test4(){
        Injector injector = Guice.createInjector();
        HelloWorld_Test t = injector.getInstance(HelloWorld_Test.class);
        t.service.execute();
    }

    @Test
    public void staticBind(){
        Injector injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.requestStaticInjection(HelloWorld_Test.class);
            }
        });
        HelloWorld_Test.service2.execute();
    }

    @Test
    public void selfInstance(){
        HelloWorld_Test test = new HelloWorld_Test();
        Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.requestInjection(test);
            }
        });
        test.service.execute();
    }

    @Test
    public void selfInstance2(){
        HelloWorld_Test test = new HelloWorld_Test();
        Guice.createInjector().injectMembers(test);
        test.service.execute();
    }

    @Test
    public void multiInterfaceServiceDemo(){
        HelloWorld_Test test = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bind(ServiceInterface.class).annotatedWith(Home.class).to(HomeService.class);
                binder.bind(ServiceInterface.class).annotatedWith(Www.class).to(WwwService.class);
            }
        }).getInstance(HelloWorld_Test.class);

        test.serviceInterface.execute();
        test.serviceInterface1.execute();

    }

}
