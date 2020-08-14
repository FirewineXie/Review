package com.study5.program_5.codes.program_5_5;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-22-15:35
 */
public class ConstructorTest {
    /*
        java 构造器并不是完全负责创建java对象，在执行new 实例的时候，java已经将建一个对象，只是这个对象并没有调用，
        只能通过this引用，，当构造器的执行体执行完之后，对象被当做返回值返回，通常赋给另一个引用变量的值。
     */
    public String name;
    public  int count;

    public ConstructorTest(String name,int count){
        //构造器里的this代表他进行初始化的对象
        //下面的两行代码将传入的2个参数赋给this代表对象的name和count实例变量

        this.count = count;
        this.name = name;

    }

    public static void main(String[] args) {

        //使用自定义的构造器来创建对象
        ConstructorTest constructorTest = new ConstructorTest("你好",8);

        //输出对象的变量
        System.out.println(constructorTest.count);
        System.out.println(constructorTest.name);

    }
}
