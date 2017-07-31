package com.ldongxu.learn.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 刘东旭 on 2017/7/6.
 */
public class ZkNodeMove {

    public static void main(String[] args) throws Exception {
        ZooKeeper newzk = new ZooKeeper("127.0.0.1:2181", 60000, null);
        ZooKeeper oldzk = new ZooKeeper("120.132.38.165:2181,120.132.38.166:2181,120.132.38.167:2181", 60000, null);
        moveZnode(oldzk,newzk,"/");

    }




    private static void moveZnode(ZooKeeper oldzk, ZooKeeper newzk, String node) throws Exception {
        List<String> children = oldzk.getChildren(node,false);
        if (children!=null&&!children.isEmpty()){
            for (String p:children){
                if (node.equals("/")) node = "";
                String path = node+"/"+p;
                System.out.println(path);
                byte[] data = oldzk.getData(path,false,null);
                if (newzk.exists(path,false)==null){
                    newzk.create(path,data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                }else {
                    newzk.setData(path,data,-1);
                }
                moveZnode(oldzk,newzk,path);
            }
        }


    }
}
