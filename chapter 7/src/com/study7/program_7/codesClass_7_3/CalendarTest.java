package com.study7.program_7.codesClass_7_3;

import java.util.Calendar;
import java.util.Date;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-03-13:02
 */
public class CalendarTest {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();

        Date date = new Date();

        Calendar calendar2 = Calendar.getInstance();

        calendar2.setTime(date);

        System.out.println(date);
    }
}
