package com.study5.program_5;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-21-21:44
 */
public class Overload {

    public static void test(){
        System.out.println("年后");
    }

    public  static void test(int n){
        System.out.println("有参数");
    }

    public static void main(String[] args) {
        test();
        test(1);
    }
}
