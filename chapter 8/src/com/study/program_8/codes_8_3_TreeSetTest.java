package com.study.program_8;

import java.util.TreeSet;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-22-10:40
 */
class Z implements Comparable{
    int age;

    public Z(int age){
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public int compareTo(Object obj) {
        return 1;
    }
}
public class codes_8_3_TreeSetTest {

    public static void main(String[] args) {

        TreeSet set = new TreeSet();
        Z z1 = new Z(6);

        set.add(z1);

        //第二次添加同一个对象，输出true 表明添加成功
        System.out.println(set.add(z1));

        System.out.println(set);

        //修改set集合的第一个元素age变量
        ((Z)(set.first())).age = 9;

        System.out.println(((Z)(set.last())).age);
    }
}
