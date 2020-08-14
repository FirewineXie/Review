package com.study5.practice_5;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-25-16:39
 */
public class student {
    private String name;
    private int age;
    private int gender;
    private int phone;
    private String address;
    private String email;

    public student(){

    }
    public student(String name,int age ,int gender,int phone,String address,String email){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.email = email;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void sleep(){
        System.out.println("睡");
    }
    public void drink(){
        System.out.println("喝");
    }
    public void eat(){
        System.out.println("吃");
    }
    public void play(){
        System.out.println("吃");
    }

}
