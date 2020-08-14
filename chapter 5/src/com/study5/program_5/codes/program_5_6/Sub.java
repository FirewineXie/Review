package com.study5.program_5.codes.program_5_6;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-22-16:26
 */
public class Sub extends  Baseclass{

    public String color;

    public Sub(double size,String name, String color){
        super(size, name);
        this.color = color;
    }

    public static void main(String[] args) {

        Sub a = new Sub(32,"nihao","绿色");

        System.out.println(a.color+a.name+a.size);
    }

}

class Baseclass{

    public double size;
    public String name;
    public Baseclass(double size,String name){
        this.size = size;
        this.name = name;
    }
}
