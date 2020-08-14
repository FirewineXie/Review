package com.study.AOP;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-07-16:58
 */
public class Test {

    public static void main(String[] args) {


        //创建一个原始的GUNDOG对象，作为Target
        Dog target = new GunDog();
        //以指定的target 来创建动态代理对象
        Dog dog = (Dog) MyProxyFactory.getProxy(target);

        dog.info();
        dog.run();
    }
}
