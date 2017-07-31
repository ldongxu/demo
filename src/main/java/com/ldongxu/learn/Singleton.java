package com.ldongxu.learn;

/**
 * Created by 刘东旭 on 2017/7/4.
 */
public enum  Singleton {
    INSTANCE;

    public void execute(){
        System.out.println("I am singleton");
    }

    public static void main(String[] args) {
        Singleton s = Singleton.INSTANCE;
        s.execute();
    }
}
