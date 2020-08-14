package com.study.program;

import java.util.Date;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-27-14:45
 */
public class codes_10_2_NullTest {
    public static void main(String[] args) {



        Date d = null;
        try {
            System.out.println(d.after(new Date()));
        }catch (NullPointerException ne){
            System.out.println("空指针异常");
        }catch (Exception e){
            System.out.println("未知异常");
        }
    }
}
