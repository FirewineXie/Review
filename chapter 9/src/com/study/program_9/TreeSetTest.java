package com.study.program_9;

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import sun.reflect.generics.tree.Tree;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-24-15:09
 */
public class TreeSetTest {
    public static void main(String[] args) {


        TreeSet<String> tes1 = new TreeSet<>(new Comparator<Object>(){
           public int compare(Object fst,Object snd){
               return hashCode() > snd.hashCode() ? 1 : hashCode() < snd.hashCode() ? -1 : 0;
           }
        });

        tes1.add("hello");
        tes1.add("wa");

        TreeSet<String> ts2 = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() > o2.length() ? -1 : o1.length() < o2.length() ? 1 : 0;
            }
        });

        ts2.add("hellp");
        ts2.add("wa");

        System.out.println(tes1);
        System.out.println(ts2);
    }
}
