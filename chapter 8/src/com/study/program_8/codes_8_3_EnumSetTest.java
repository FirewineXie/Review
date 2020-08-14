package com.study.program_8;

import javax.naming.directory.SearchControls;
import java.util.EnumSet;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-22-13:08
 */
enum Season{
    SPRING,SUMMER,FAIL,WINTEER
}
public class codes_8_3_EnumSetTest {

    public static void main(String[] args) {
        //创建一个EnumSet集合，集合元素就是Season枚举类的全部枚举值
        EnumSet es1 = EnumSet.allOf(Season.class);

        System.out.println(es1);
        //创建一个EnumSet空集合，指定其集合元素是Season的枚举值
        EnumSet es2 = EnumSet.noneOf(Season.class);
        System.out.println(es2);

        es2.add(Season.WINTEER);
        es2.add(Season.SPRING);
        System.out.println(es2);

        //以指定的枚举值创建EnumSet集合
        EnumSet es3 = EnumSet.of(Season.SUMMER,Season.WINTEER);

        System.out.println(es3);
        EnumSet es4 = EnumSet.of(Season.SPRING,Season.FAIL);

        System.out.println(es4);

        EnumSet es5 = EnumSet.complementOf(es4);
        System.out.println(es5);



    }
}
