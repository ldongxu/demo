package com.ldongxu.designPatterns.clone;


/**
 * @author liudongxu06
 * @since 2019-04-15
 */
public class ConcretePrototype implements Cloneable{

    private String name;
    private int age;
    private Integer sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
