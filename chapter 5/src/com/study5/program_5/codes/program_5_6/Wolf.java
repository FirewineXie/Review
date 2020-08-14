package com.study5.program_5.codes.program_5_6;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-22-16:32
 */
/*

    通过这个案例，就可以明白，为什么java.lang.Object 是第一个执行的，
    由这样一层一层的往下的执行的。但是object不是显示的，所有不显示，，不代表不执行
 */
public class Wolf extends Animal{

    public Wolf(){

        //现实调用父类有两个参数的构造器
        super("灰太狼",3);
        System.out.println("wolf的无参构造器");
    }

    public static void main(String[] args) {

        new Wolf();
    }

}

class Creature{

    public Creature(){

        System.out.println("Creature的无参构造器");
    }
}
class Animal extends Creature{
    public int age ;
    public Animal(String name){
        System.out.println("Animal 带一个参数的构造器，"+"该动物的name为："+name);
    }

    public Animal(String name,int age){
        this(name);
        System.out.println("Animal带两个参数的构造器，"+"age的值："+ age);
    }
}
