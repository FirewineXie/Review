package com.study.program_8;

import java.util.ArrayList;
import java.util.List;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-22-16:43
 */
public class codes_8_4_ListTest {

    public static void main(String[] args) {

        List books = new ArrayList();

        books.add("nihao");
        books.add("fnegjian ");
        books.add("ddf");

        System.out.println(books);

        books.add(1,new String("123"));
        for (int i = 0;i<books.size();i++){
            System.out.println(books.get(i));
        }



    }
}
