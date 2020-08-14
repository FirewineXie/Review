package com.study5.program_5;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-21-21:31
 */
public class Varargs {

    public static void test(int a,String ... books){

        //books被当做数组处理

        for (String tmp : books){
            System.out.printf(tmp);
        }

        System.out.println(a);
    }

    public static void main(String[] args) {

        test(5,"你好","他好","我好","大家好");
    }
}
