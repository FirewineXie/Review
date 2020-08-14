package com.java.thought.note;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: 穷举算法 .java
 * @Create : 2019-05-15-19:56
 * @Description :
 */
public class 穷举算法 {

    static int chichen , habbbit;
    public static int qiongju(int head,int foot){
        int re,i,j;

        re = 0;
        for (i = 0; i <= head; i++) {
            j = head-i;
            if (i * 2 + j * 4 == foot) {
                re =1;
                chichen=i;
                habbbit=j;
            }
        }
        return  re;
    }


    public static void main(String[] args) {

        int re,head,foot;

        Scanner input = new Scanner(System.in);
        head = input.nextInt();
        foot = input.nextInt();
        re = qiongju(head, foot);
    }
}
