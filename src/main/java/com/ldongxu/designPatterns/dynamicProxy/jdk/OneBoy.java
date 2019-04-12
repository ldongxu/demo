package com.ldongxu.designPatterns.dynamicProxy.jdk;

/**
 * @author liudongxu06
 * @since 2019-04-12
 */
public class OneBoy implements Person{

    private String name = "小星星";
    private String sex = "男";

    public void findLove() {
        System.out.println("我是小星星。");
        System.out.println("想找一个女朋友。");
        System.out.println("希望身高160cm，美丽大方又可爱。");
    }

    public String getName() {
        System.out.println("我的名字是:"+name);
        return name;
    }

    public String getSex() {
        return sex;
    }
}
