package com.study.AOP;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-07-16:37
 */
public class GunDog  implements Dog{
    @Override
    public void info() {
        System.out.println("我是一个腊狗");
    }

    @Override
    public void run() {
        System.out.println("我奔跑迅速");
    }
}
