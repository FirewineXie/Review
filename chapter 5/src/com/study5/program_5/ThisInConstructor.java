package com.study5.program_5;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-21-21:01
 */
public class ThisInConstructor {

    public int foo;

    public ThisInConstructor(){


        //在构造器中创建一个foo变量
        int foo = 0;

        //使用this代表该构造器正在初始化对象
        /*
            当出现重名的变量，又必须在构造器中访问这个被覆盖的成员变量，则必须使用this前缀，
         */
        this.foo = 6;//可以更改成员变量foo为6
    }

    public static void main(String[] args) {
        System.out.println(new ThisInConstructor().foo);
    }
}
