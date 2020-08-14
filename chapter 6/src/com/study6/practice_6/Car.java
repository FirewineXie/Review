package com.study6.practice_6;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-02-16:37
 */
public abstract class Car {
    private String name;

    public abstract void info();
}


class  Tuolaji extends Car{

    @Override
    public void info() {
        System.out.println("这是拖拉机");
    }
}
class Track extends Car{
    @Override
    public void info() {
        System.out.println("卡车");
    }
}

class smallCar extends Car{
    @Override
    public void info() {
        System.out.println("这是小轿车");
    }
}
