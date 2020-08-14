package com.study.program_8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-20-12:21
 */
public class codes_8_2_Collection {
    public static void main(String[] args) {

        Collection c = new ArrayList();

        c.add("孙悟空");
        c.add(6);

        System.out.println("c的元素个数是："+c.size());

        System.out.println("c的集合是否包含孙悟空字符串 -"+c.contains("孙悟空"));


        Collection books = new HashSet();

        books.add("java疯狂");
        c.removeAll(books);


        c.clear();

        System.out.println("C 的元素"+c);

        books.retainAll(c);

        System.out.println("books集合的元素"+books);
    }
}
