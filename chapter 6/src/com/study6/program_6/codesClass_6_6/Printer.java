package com.study6.program_6.codesClass_6_6;

import com.sun.corba.se.pept.encoding.OutputObject;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-28-14:39
 */
interface Product{
    int getProduceTime();
}
interface Output{
    //接口定义的成员变量只能是常量
    int MAX_CACHE_LINE = 50;
    //接口类定义的普通方法只能是public的抽象方法
    void out();
    void getData(String msg);

    default void print(String ... msgs){
        for (String msg : msgs){
            System.out.println(msg);
        }
    }

    default String staticTest(){
        return "接口里的类方法";
    }
    default void test(){
        System.out.println("默认的test 方法");
    }

    //这应该是private
/*     static void foo(){
        System.out.println("foo 私有方法");
    }*/



}
public class Printer implements Output,Product {

    private String[] printData = new String[MAX_CACHE_LINE];


    private int dataNum = 0;

    @Override
    public void out() {
        //只要还有作业，就继续打印
        while (dataNum > 0){
            System.out.println("打印机打印："+printData[0]);
            System.arraycopy(printData,1,printData,0,--dataNum);
        }
    }

    @Override
    public void getData(String msg) {
        if (dataNum >= MAX_CACHE_LINE){
            System.out.println("输出队列已满，添加失败");
        }else {
            printData[dataNum++] = msg;
        }
    }

    @Override
    public int getProduceTime() {
        return 45;
    }


    public static void main(String[] args) {
        //创建一个Printer对象，当成Output使用
        Output o = new Printer();
        o.getData("轻量级javaee");
        o.getData("疯狂java讲义");
        o.out();
        o.getData("疯狂Android");
        o.getData("疯狂ajax");
        o.out();

        o.print("孙悟空","猪八戒","白骨精");
        o.test();

        //创建一个printer对象，，当成Product使用
        Product p = new Printer();

        System.out.println(p.getProduceTime());

        Object obj = p;
    }
}
