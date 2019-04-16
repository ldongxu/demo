package com.ldongxu.designPatterns.clone;

/**
 * @author liudongxu06
 * @since 2019-04-15
 */
public class ProtoTypeTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        ConcretePrototype cp = new ConcretePrototype();
        cp.setAge(18);
        cp.setName("liudongxu");
        cp.setSex(1);

        ConcretePrototype copy = (ConcretePrototype) cp.clone();
        System.out.println(copy.getAge()+","+copy.getName());
        System.out.println(cp.getSex()==copy.getSex());

    }
}
