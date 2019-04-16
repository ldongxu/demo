package com.ldongxu.designPatterns.dynamicProxy.custom;

/**
 * @author liudongxu06
 * @since 2019-04-16
 */
public class XiaoWang implements GpPerson {
    private String name = "小王";
    private String sex = "男";
    @Override
    public void findLove() {
        System.out.println("我想找个白富美。");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSex() {
        return sex;
    }
}
