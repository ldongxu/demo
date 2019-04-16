package com.ldongxu.designPatterns.dynamicProxy.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author liudongxu06
 * @since 2019-04-12
 */
public class TestDynamicProxy {
    public static void main(String[] args) throws IOException {
        Person person = (Person) new Meipo().getInstance(new OneBoy());
        person.findLove();
        System.out.println(person.getClass());


        //获取生成的代理对象字节码内容
//        byte[] data = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Person.class});
//        FileOutputStream os = new FileOutputStream("$Proxy0.class");
//        os.write(data);
//        os.close();

    }
}
