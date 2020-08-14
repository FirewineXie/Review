package com.study3.program_3;

/**
 * @Auther : xie     xyjworkgame@163.com
 * Program Name: <br>
 * @Version : 1.0
 * @Create : 2018-08-19-12:30
 */
public class codes_34_IntegerValTest {
    public static void main(String[] args) {

        //以0开头的整数值是八进制的整数
        int octalValue = 013;
        //以0x或0X开头的整数值是十六进制的整数
        int hexValue1 = 0x13;
        int hexValue2 = 0xaf;


        System.out.println(octalValue + "\t" + hexValue1 +"\t" + hexValue2);
    }


}
