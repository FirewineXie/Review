package com.study.jdk_动态代理;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-07-14:00
 */
public interface Subject {
    /**
     * 你好
     * @param name
     * @return
     */
    public String SayHello(String name);


    /**
     * 再见
     * @return
     */
    public String SayGoodBye();
}
