package com.ldongxu.learn;

/**
 * Created by 刘东旭 on 2017/7/7.
 */
public class InnerClass {
    private String operation;
    private static String operator;
    private int size =0;

    public void invoceInner(){
        new Inner().getSize();
    }

    public void invokeInner(){
        new Inner(this).allSize();
    }
    public static class StaticClass{
        public void op(){
            System.out.println(operator);
        }
    }

    private class Inner{
        private int size=1;
        private InnerClass innerClass;
        public Inner() {
        }

        public Inner(InnerClass in) {
            this.innerClass=in;
        }

        public void getSize(){
            System.out.println(size);
            System.out.println(this.size);
        }

        public void allSize(){
            System.out.println(size);
            System.out.println(this.size);
            System.out.println(innerClass.size);
        }
    }

    public static void main(String[] args) {
        new InnerClass().invoceInner();
        System.out.println();
        new InnerClass().invokeInner();

    }
}
