package com.ldongxu.learn;

import java.io.Serializable;

/**
 * Created by 刘东旭 on 2017/6/5.
 */
public class Person implements Serializable{
    private String name;
    private Email email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public void test(){
        final Email e = this.email;
        e.setContent("fasfs");
        System.out.println(e.getContent());
        System.out.println(this.email.getContent());

    }

    public static class Email implements Serializable{
        private String content;

        public Email(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    public class Address {
        private String home;

        public String getHome() {
            return home;
        }

        public void setHome(String home) {
            this.home = home;
        }
    }

    public static void main(String[] args) {
//        testClone();
        Email email = new Email("请今天上午11：09开会");
        Person person = new Person();
        person.setName("测试final引用");
        person.setEmail(email);

        person.test();

    }

    public static void testClone(){
        Email email = new Email("请今天上午11：09开会");
        Person person = new Person();
        person.setName("刘东旭");
        person.setEmail(email);

        Person.Address address = new Person().new Address();
        System.out.println(person.getName()+"的邮件内容："+person.getEmail().getContent());

        Person person1 = CloneUtils.clone(person);

        System.out.println(person.equals(person1));

        person1.getEmail().setContent("不用开会啦");
        System.out.println(person1.getName()+"的邮件内容："+person1.getEmail().getContent());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email=" + email +
                '}';
    }
}
