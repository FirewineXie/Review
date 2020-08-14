package com.study.program_8;

import java.util.TreeSet;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-22-11:17
 */
class M{
    int age;
    public M(int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return "M [age:"+age+"]";
    }
}

public class codes_8_3_TreeSetTest4 {

    public static void main(String[] args) {

        //此处的Lambda表达式的目标类型是Comparator
        TreeSet ts = new TreeSet((o1, o2) ->
        {
           M m1 =(M)o1;
           M m2 =(M)o2;
           //根据M对象的age属相来决定大小，age越大，m对象反而越大
            return m1.age > m2.age ? -1 : m1.age < m2.age ? 1:0;
        });


        ts.add(new M(5));
        ts.add(new M(-3));
        ts.add(new M(9));
        System.out.println(ts);
    }
}
