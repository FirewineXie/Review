package com.study.practice_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-23-17:00
 */
public class two {

    public static void main(String[] args) {

        List lit = new ArrayList();

        for (int i=0;i<10;i++){
            lit.add(i);
        }


        System.out.println(lit.get(5));

        lit.remove(3);
        System.out.println(lit);
    }
}
