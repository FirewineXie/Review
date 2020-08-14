package com.java.thought.note;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: 概率算法 .java
 * @Create : 2019-05-15-20:34
 * @Description :
 */
public class 概率算法 {


    static double MontePI(int n) {
        double PI;
        double x,y;

        int i,sum;
        sum=0;

        for (i = 1; i < n; i++) {
            x = Math.random();
            y = Math.random();
            if (x * x + y * y <= 1) {
                sum++;
            }
        }
        PI = 4.0 * sum/n;
        return PI;
    }


    public static void main(String[] args) {
        int n;
        double PI;


        Scanner input = new Scanner(System.in);
        n = input.nextInt();//撒点数
        PI = MontePI(n);
        System.out.println(PI);
    }
}
