package com.ldongxu.learn;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 刘东旭 on 2017/6/2.
 * <p>
 * asList的缺陷
 */
public class AsList_Test {
    public static void main(String[] args) {
        asListIntsPara();
        System.out.println("=========");
        asListUnOpt();

    }

    /**
     *  避免使用基本数据类型数组转换为List
     */
    public static void asListIntsPara() {
        int[] ints = {1, 2, 2, 1, 3};
        List list = Arrays.asList(ints);
        System.out.println(list.size());
        System.out.println(list.get(0).equals(ints));

        Integer[] integers = {1, 2, 2, 1, 3};
        List list1 = Arrays.asList(integers);
        System.out.println(list1.size());
    }

    /**
     * asList 产生的列表不可操作
     */
    public static void asListUnOpt() {
        Integer[] integers = {1, 2, 2, 1, 3};
        List list1 = Arrays.asList(integers);
        System.out.println(list1.size());
        list1.add(6);
    }
}
