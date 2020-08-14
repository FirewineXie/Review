package com.study6.program_6.codesClass_6_1;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-25-20:47
 */
public class AutoBoxing {

    public static void main(String[] args) {

        //直接把一个基本类型变量赋给Integer对象

        Integer inObj = 5;
        //将boolean变量赋给object对象
        Object boolobj = true;

        int it = inObj;
        if (boolobj instanceof Boolean){
            boolean b = (Boolean)boolobj;
            System.out.println(b);
        }
    }
}
