package com.study6.program_6.codesClass_6_6;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-28-15:42
 */
public class Computer {
    private Output out;

    public Computer(Output out){
        this.out = out;
    }

    //定义一个模拟获取字符串输入的方法

    public void keyIn(String msg){
        out.getData(msg);
    }

    //定义一个模拟打印的方法
    public void print(){
        out.out();
    }
}
