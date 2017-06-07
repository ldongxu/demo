package com.ldongxu;


import com.ldongxu.learn.Person;

import java.lang.reflect.Method;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {

        Method[] methods = Person.class.getMethods();
        for (Method method:methods){
            System.out.println(method.getName());
            System.out.println(method.getParameterCount());
        }
    }



    public static int average(int x,int y){
        return (x&y)+((x^y)>>1);
    }


}
