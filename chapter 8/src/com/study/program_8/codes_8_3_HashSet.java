package com.study.program_8;

import java.util.HashSet;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-20-20:00
 */
class A{
    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
class B{
    @Override
    public int hashCode() {
        return 1;
    }
}
class C{
    @Override
    public int hashCode() {
        return 2;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
public class codes_8_3_HashSet {
    public static void main(String[] args) {

        HashSet books = new HashSet();

        books.add(new A());
        books.add(new A());
        books.add(new B());
        books.add(new B());
        books.add(new C());
        books.add(new C());


        System.out.println(books);
    }
}
