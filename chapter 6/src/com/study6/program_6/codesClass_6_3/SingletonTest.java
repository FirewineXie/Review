package com.study6.program_6.codesClass_6_3;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-26-22:52
 */
class Singleton{

    private static Singleton instance;
    //如果要判断是否只有一个对象，，首先创建一个类变量，来缓存已经创建的变量，不然，该类不知道是否曾经创建过对象

    private Singleton(){}

    public static Singleton getInstance(){

        //如果instance 为null  则创建一个
        //不是空，则表示已经创建过对象

        if (instance == null){
            instance = new Singleton();
        }
        return  instance;
    }
}
public class SingletonTest {

    public static void main(String[] args) {

        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton1 == singleton2);
    }
}
