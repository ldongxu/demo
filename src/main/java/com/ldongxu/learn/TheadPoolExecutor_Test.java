package com.ldongxu.learn;

import java.util.concurrent.*;

/**
 * Created by 刘东旭 on 2017/7/3.
 */
public class TheadPoolExecutor_Test {
    private static ScheduledExecutorService threadPoolExecutor = new ScheduledThreadPoolExecutor(5);

    public static void main(String[] args) {
        for (int i=0;i<5;i++){
            System.out.println(i);
            threadPoolExecutor.scheduleAtFixedRate(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" start");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+" end");
                }
            },0,1, TimeUnit.SECONDS);
        }
    }

}
