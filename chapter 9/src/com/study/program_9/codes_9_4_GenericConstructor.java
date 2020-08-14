package com.study.program_9;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-24-16:01
 */
class Foo1{
    public <T> Foo1(T t){
        System.out.println(t);
    }
}
public class codes_9_4_GenericConstructor {

    public static void main(String[] args) {

        //泛型构造器中的T类型为String
        new Foo1("疯狂java定义");
        //泛型构造器中的T类型为Interger “”“自动装箱
        new Foo1("200");
        //显示指定泛型构造器中的T类型为String
        //传给Foo构造器的实参也是String对象，完全正确

        new <String> Foo1("疯狂A内容ID");

        //如果显示指定为String，但是里面传入的是double对象，就回出错
    }
}
