package com.study6.program_6.codesClass_6_1;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-26-21:56
 */
public class UnsignedTest {

    public static void main(String[] args) {
        byte b  =-3;
        //将byte类型转换成无符号整数
        System.out.println("byte d类型转换成无符号整数："+Byte.toUnsignedInt(b));

        //指定十六进制解析无符号整数
        int val  = Integer.parseUnsignedInt("ab",16);

        System.out.println(val);

        System.out.println("将-12 转换成无符号并且为16进制 "+Integer.toUnsignedString(-12,16));

        System.out.println("将两个数转换成无符号整数后相除"+Integer.divideUnsigned(-2,3));

        System.out.println("将两个数转换成无符号整数后相除"+Integer.remainderUnsigned(-2,3));


    }
}
