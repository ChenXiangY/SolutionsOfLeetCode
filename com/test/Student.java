package com.test;

/**
 * @author Chen Xiangyu
 * @version 1.0
 * @classname Student
 * @date 2019/1/31
 */
public class Student {
    private String name;
    public String home;
    public int age;

    public Student() {
        System.out.println("无参的构造器被调用了.");
    }

    public Student(int age) {
        this.age = age;
        System.out.println("My age is + " + age);
    }

    public Student(String home) {
        this.home = home;
        System.out.println(home  +" \t<====\t home");
    }

    private Student(String name, String home) {
        this.name = name;
        this.home = home;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void sell(int age,String name) {
        System.out.println(age + "\n "+name);
    }
}
