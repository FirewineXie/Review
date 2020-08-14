package com.study5.program_5.codes.program_5_9;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-25-16:31
 */
public class Test {

    public static void main(String[] args) {
        new Leaf();
    }
}
class Root{
    static {
        System.out.println("Root 的静态初始化块");
    }
    {
        System.out.println("Root的普通初始化块");
    }
    public Root(){
        System.out.println("Root的无参数构造器");
    }
}

class Mid extends Root{
    static {
        System.out.println("Mid 的静态初始化块");
    }
    {
        System.out.println("Mid 的普通初始化块");
    }
    public Mid(){
        System.out.println("Mid 的无参数的构造器");
    }
    public Mid(String msg){
        this();
        System.out.println("Mid 的带参数构造器，其参数值："+msg);
    }
}
class Leaf extends Mid{
    static {
        System.out.println("Leaf 的静态初始化块");
    }
    {
        System.out.println("Leaf 的普通初始化块");
    }
    public Leaf(){
        System.out.println("Leaf 的无参数的构造器");
    }
    public Leaf(String msg){
        this();
        System.out.println("Leaf 的带参数构造器，其参数值："+msg);
    }
}