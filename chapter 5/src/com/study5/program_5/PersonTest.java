package com.study5.program_5;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-21-22:00
 */
public class PersonTest {

    public static void main(String[] args) {

        //第一次主动使用Person类，该类自动初始化，就是eyeNum 的值会变为0
        System.out.println("Person 类的eyeNum的变量值："+Person.eyeNum);

        //创建Person类对象
        Person person = new Person();

        //通过对象访问name的值和eyeNum 的值

        System.out.println("实例化后，Person的name和eyeNum的值："+person.name+"   " + person.eyeNum);


        //向name 赋值，eyename赋值
        person.name = "孙悟空";

        person.eyeNum = 2;

        //再次输出实例变量的两个值
        System.out.println("实例化后修改后，Person的name和eyeNum的值："+person.name+"   " + person.eyeNum);

        //再次输出类变量的值
        System.out.println("Person 类的eyeNum的变量值修改后："+Person.eyeNum);

        Person person1 = new Person();
        //输出第二次实例的变量的值
        System.out.println("第二个实例化后，Person的name和eyeNum的值："+person1.name+"   " + person1.eyeNum);
    }
}
class Person{
    public String name;

    public static int eyeNum;
}