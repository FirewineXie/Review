package com.study5.program_5.codes.program_5_7;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-22-16:43
 */
public class SubClass extends  BaseClass{

    //重新定义一个book变量来隐藏父类的book实例变量
    public String book = "你好";

    @Override
    public void test() {
        System.out.println("子类的覆盖父类的方法");
    }
    public void sub(){
        System.out.println("子类的普通方法");
    }

    public static void main(String[] args) {

        //同时实例子类和父类，并输出实例变量
        SubClass subClass = new SubClass();
        System.out.println(subClass.book);

        BaseClass baseClass = new BaseClass();
        System.out.println(baseClass.book);

        //上面实例化，编译和运行都是一个类型，不存在多态。

        BaseClass base = new SubClass();
        //输出的是父类的实例变量
        System.out.println(base.book);
        //调用的是从父类继承到的base方法
        base.base();

        //下面调用的是当前类的test方法
        base.test();
        //因为父类没有sub方法，，故不能调用sub方法，会报错
        //因为编译类型是BaseClass

        //base.sub();
    }
}

class BaseClass{
    public int book = 6;

    public void base(){
        System.out.println("父类的普通方法");
    }
    public void test(){
        System.out.println("父类的被覆盖的方法");
    }
}
