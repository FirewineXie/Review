package com.study.program_8;

import java.util.Collection;
import java.util.HashSet;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-20-13:14
 */
public class codes_8_2_CollectionEach {

    public static void main(String[] args) {

        //创建一个集合
        Collection books = new HashSet();
        books.add("1");
        books.add("2");
        books.add("3");
        books.add("4");
        books.add("5");
        books.add("6");
        books.add("7");

        books.forEach(obj -> System.out.println("迭代集合元素" + obj));

    }
}
