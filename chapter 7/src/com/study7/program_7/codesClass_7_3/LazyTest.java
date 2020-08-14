package com.study7.program_7.codesClass_7_3;

import java.util.Calendar;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-03-13:10
 */
public class LazyTest {

    public static void main(String[] args) {

        Calendar cal = Calendar.getInstance();
        cal.set(2003,7,31);

        cal.set(Calendar.MONTH,9);

        System.out.println(cal.getTime());

        cal.set(Calendar.MONTH,10);
        System.out.println(cal.getTime());
    }
}
