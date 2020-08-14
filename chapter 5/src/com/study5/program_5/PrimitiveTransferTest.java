package com.study5.program_5;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-21-21:11
 */
public class PrimitiveTransferTest {

    /**
     *
     * 这是基本类型的参数传递
     * a  b值互换
     * @param a
     * @param b
     */
    public static void swap(int a,int b){
        int tmp = a;

        a = b;

        b = tmp;
        System.out.println("交换后的值 a = " + a +"\n交换后的值 b = "+b);
    }


    public static void main(String[] args) {
        int a = 7;
        int b = 6;

        swap(a,b);
        System.out.println("交换后的值 a = " + a +"\n交换后的值 b = "+b);
    }
}
