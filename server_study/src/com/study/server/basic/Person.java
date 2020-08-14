package com.study.server.basic;

/**
 * @author : Firewine
 * @version : 1.0
 * @Program Name: Persion
 * @Create : 2020/1/12
 * @Description :
 */
public class Person {

    private String name;
    private int age;
    public Person(){

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
}
