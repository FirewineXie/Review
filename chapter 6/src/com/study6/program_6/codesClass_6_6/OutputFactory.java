package com.study6.program_6.codesClass_6_6;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-28-15:44
 */
public class OutputFactory {

    public Output getOutput(){

        //这就是工厂模式，就像是一个电脑需要打印机一样。可是每个打印机都有着不同的功能，所以电脑不能死连着一台，所以就需要
        //拿一跟线扩展，，，下面这个就时线，，可以选择连接那个打印机
        return new BetterPrinter();
    }

    public static void main(String[] args) {
        OutputFactory of = new OutputFactory();

        Computer c = new Computer(of.getOutput());

        c.keyIn("1");
        c.keyIn("2");
        c.print();
    }
}
