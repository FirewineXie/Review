package com.study7.program_7.codesClass_7_3;

import java.math.BigDecimal;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-03-11:27
 */
public class BigDecimalTest {


    public static void main(String[] args) {

        BigDecimal f1 = new BigDecimal("0.05");
        BigDecimal f2 = BigDecimal.valueOf(0.01);
        BigDecimal f3 = new BigDecimal(0.05);

        System.out.println("使用String作为BigDecmal构造器参数：");
        System.out.println(f1.add(f2));


        System.out.println("使用double作为构造器参数");
        System.out.println(f3.add(f1));
    }
}
