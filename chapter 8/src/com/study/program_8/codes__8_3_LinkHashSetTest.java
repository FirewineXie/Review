package com.study.program_8;

import java.util.LinkedHashSet;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-22-10:13
 */
public class codes__8_3_LinkHashSetTest {

    public static void main(String[] args) {

        LinkedHashSet books = new LinkedHashSet();
        books.add("1313232");
        books.add("343545");

        System.out.println(books);

        books.remove("1313232");
        books.add("1214121");

        System.out.println(books);
    }
}
