package com.java.thought.note;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: 递推算法 .java
 * @Create : 2019-05-15-20:00
 * @Description :
 */
public class 递推算法 {

    public static int fibonacci(int n) {
        int t1,t2;

        if (n == 1 || n == 2) {
            return 1;
        }else {
            t1 = fibonacci(n - 1);
            t2 = fibonacci(n - 2);
            return t1+t2;
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int num = fibonacci(n);
        System.out.printf("经过"+n+"月时间，共繁殖："+num+"兔子");
    }
}
