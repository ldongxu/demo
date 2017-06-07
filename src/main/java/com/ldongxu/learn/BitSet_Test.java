package com.ldongxu.learn;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;

/**
 * Created by 刘东旭 on 2017/6/1.
 * <p>
 * 通过BitSet来检测一个数字是否存在:
 * 现在有5个随机数，随机数的范围在1到10之间。现在要求写出一种算法，将1到10之间没有在随机数中的数求出来.
 */
public class BitSet_Test {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            int rn = random.nextInt(10);
            list.add(rn);
        }
        System.out.println("产生的随机数有：");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        BitSet bitSet = new BitSet(10);
        for (int i = 0; i < 5; i++) {
            bitSet.set(list.get(i));
        }
        System.out.println("不在随机数中的有：" + bitSet.size());
        for (int i = 0; i < 10; i++) {
            if (!bitSet.get(i)) {
                System.out.println(i);
            }
        }
    }
}
