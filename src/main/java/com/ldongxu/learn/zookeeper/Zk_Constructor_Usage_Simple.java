package com.ldongxu.learn.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * 创建一个最基本的zookeeper会话实例
 * <p>
 *   注意：Zookeeper客户端和服务端会话的建立是一个异步的过程，也就是说在程序中，构造方法会在处理完客户端初始化工作之后立即返回，
 *   在大多数情况下，此时并没有真正建立好一个可用的会话，在会话的生命周期中处于"CONNECTING"的状态。
 *
 * Created by 刘东旭 on 2017/6/27.
 */
public class Zk_Constructor_Usage_Simple implements Watcher {
    private static CountDownLatch connected = new CountDownLatch(1);

    public void process(WatchedEvent watchedEvent) {
        System.out.println("Receive watched event:" + watchedEvent);
        if (watchedEvent.getState()== Event.KeeperState.SyncConnected) {
            connected.countDown();
        }
    }

    public static void main(String[] args) throws IOException {
        ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 5000, new Zk_Constructor_Usage_Simple());
        System.out.println(zooKeeper.getState());
        try {
            connected.await();
        } catch (InterruptedException e) {
            System.out.println("Zookeeper session established.");
        }


    }
}
