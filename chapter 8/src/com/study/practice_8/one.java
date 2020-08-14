package com.study.practice_8;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-23-16:56
 */
public class one {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set set = new HashSet<String>();

        for (int i=0;i<5;i++){
            set.add(sc.next());
        }

        System.out.println(set.size());
        System.out.println(set);
    }
}
