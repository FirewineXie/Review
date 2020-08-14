package com.reflection.study.bean;

/**
 * @author : Firewine
 * @version : 1.0
 * @Program Name: User
 * @Create : 2020/1/13
 * @Description : 测试java.lang.Class对象的获取方式
 */

public class User {
   private int id;
   private int age;
   private String uname;

    public User() {
    }

    public User(int id, int age, String uname) {
        this.id = id;
        this.age = age;
        this.uname = uname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
