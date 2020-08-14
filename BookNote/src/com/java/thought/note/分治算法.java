package com.java.thought.note;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: 分治算法 .java
 * @Create : 2019-05-15-20:14
 * @Description :
 */
public class 分治算法 {

    static final int MAXNUM = 30;

    static int FalseCoin(int coin[], int low, int high) {
        int i, sum1, sum2, sum3;
        int re = 0;

        sum1 = sum2 = sum3 = 0;
        if (low + 1 == high) {
            if (coin[low] < coin[high]) {
                re = low + 1;
                return re;
            } else {
                re = high + 1;
                return re;
            }
        }
        //n是偶数
        if ((high - low + 1) % 2 == 0) {
            for (i = low; i <= low + (high - low) / 2; i++) {
                //前半段求和
                sum1 = sum1 + coin[i];
            }
            for (i = low + (high - low) / 2 + 1; i <= high; i++) {
                //后半段求和
                sum2 = sum2 + coin[high];
            }
            if (sum1 > sum2) {
                re = FalseCoin(coin, low + (high - low) / 2 + 1, high);
                return re;
            } else if (sum1 < sum2) {
                re = FalseCoin(coin, low, low + (high - low) / 2);
                return re;
            } else {

            }
        } else {
            for (i = low; i <= low + (high - low) / 2 - 1; i++) {
                //前半段求和
                sum1 = sum1 + coin[i];
            }
            for (i = low + (high - low) / 2 + 1; i <= high; i++) {
                //后半段求和
                sum2 = sum2 + coin[i];
            }
            sum3 = coin[low + (high - low) / 2];
            if (sum1 > sum2) {
                re = FalseCoin(coin, low + (high - low) / 2 + 1, high);
                return re;
            } else if (sum1 < sum2) {
                re = FalseCoin(coin, low, low + (high - low) / 2 - 1);
                return re;
            } else {

            }
            if (sum1 + sum3 == sum2 + sum3) {
                re = low + (high - low) / 2 + 1;
                return re;
            }
        }
        return re;
    }


    public static void main(String[] args) {
        int[] coin = new int[MAXNUM];
        int i, n;

        int locaticon;
        Scanner input = new Scanner(System.in);

        n = input.nextInt();//硬币个数
        System.out.println("输入真假");
        for (i = 0; i < n; i++) {
            coin[i] = input.nextInt();
        }
        locaticon = FalseCoin(coin, 0, n - 1);
        System.out.println(locaticon);
    }
}
