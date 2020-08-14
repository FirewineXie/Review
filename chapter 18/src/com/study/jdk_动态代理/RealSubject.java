package com.study.jdk_动态代理;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-07-14:01
 */
public class RealSubject implements Subject {
    @Override
    public String SayHello(String name) {
        return "hello" + name;
    }

    @Override
    public String SayGoodBye() {
        return "good bye";
    }
}
