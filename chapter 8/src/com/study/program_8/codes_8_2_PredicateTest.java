package com.study.program_8;


import java.util.Collection;
import java.util.HashSet;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-20-14:03
 */
public class codes_8_2_PredicateTest {

    public static void main(String[] args) {

        Collection books = new HashSet();

        books.add("fdafa343");
        books.add("fdafa43");
        books.add("fdafa4433");
        books.add("fdafa53");;
        books.add("fdafa5454fddgfd");

        books.removeIf(ele -> ele.toString().length() <10);
        System.out.println(books);

    }

}
