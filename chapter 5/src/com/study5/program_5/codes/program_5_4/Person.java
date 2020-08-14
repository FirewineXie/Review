package com.study5.program_5.codes.program_5_4;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-22-13:26
 */
public class Person {

    private String name;
    private int age;


    public void setName(String name) {
        if (name.length() > 6 || name.length() <2){
            System.out.println("你输入的不符合要求");
            return;
        }else {

            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {

        if (age > 100 || age < 0){
            System.out.println("设置年龄不合法");
            return;
        }else {

            this.age = age;
        }
    }

    public int getAge() {
        return age;
    }
}
