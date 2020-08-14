package com.study7.program_7.codesClass_7_6;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-03-20:50
 */
public class MethodHandleTest {
    //定义一个private类方法
    private static void hello(){
        System.out.println("hello  world");
    }


    //定义一个实例方法
    private String hello(String name){
        System.out.println("执行带参数的hello" + name);
        return name + "你好";
    }

    public static void main(String[] args)throws Throwable {
        //定义一个返回值为void，不带形参的方法类型
        MethodType type = MethodType.methodType(void.class);

        //使用MethodHandles.lookup的findstatic 获取类方法
        MethodHandle mtd = MethodHandles.lookup().findStatic(MethodHandleTest.class,"hello",type);

        //通过MethodHandle 执行方法
        mtd.invoke();

        //使用MethodHandles.lookup的fingV方法获取实例
        MethodHandle mtd2 = MethodHandles.lookup().findVirtual(MethodHandleTest.class,"hello",
                MethodType.methodType(String.class,String.class));


        System.out.println(mtd2.invoke(new MethodHandleTest(),"孙悟空"));
    }
}
