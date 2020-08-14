package com.study.program_8;

import java.util.Collection;
import java.util.HashSet;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-20-15:26
 */
public class codes_8_2_CollecionStream {

    public static void main(String[] args) {


        Collection books = new HashSet();

        books.add("fdafa343");
        books.add("fdafa43");
        books.add("fdafa4433");
        books.add("fdafa53");;
        books.add("fdafa5454fddgfd");

        //统计书名包含的内容进行计算数量
        System.out.println(books.stream()
                            .filter(ele ->((String)ele).contains("fd"))
                            .count());


    }
}
