package com.study.program_9;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-23-20:26
 */
interface Foo<T>{

    void test(T t);
}

public class codes_9_1_AnnoymousDiamond {


    public static void main(String[] args) {

        Foo<String> f= new Foo<String>() {
            @Override
            public void test(String s) {
                System.out.println("test 方法的t参数为：" +s);
            }
        };

        Foo<?> fp = new Foo<Object>() {
            @Override
            public void test(Object o) {
                System.out.println("test的参数object参数为："+o);
            }
        };

        Foo<? extends Number> fn = new Foo<Number>() {
            @Override
            public void test(Number number) {
                System.out.println("test的number的参数："+number);
            }
        };
    }
}
