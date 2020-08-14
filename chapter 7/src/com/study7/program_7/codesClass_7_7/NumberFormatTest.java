package com.study7.program_7.codesClass_7_7;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-04-12:37
 */
public class NumberFormatTest {
    /*
        NumberFormat 和DateFormat 的都是可以实现数字、日期的格式化，
        format 是将数值或日期格式化成字符串
        parse  是将字符串格式化数值或日期

        里面具体的方法可以看api文档

     */

    public static void main(String[] args) {

        double db = 1234000.567;
        //中 日德 美
        Locale[] locales = {Locale.CHINA,Locale.JAPAN,Locale.GERMAN,Locale.US};

       NumberFormat[] nf = new NumberFormat[12];


       for (int i=0;i<locales.length;i++){
           nf[i * 3] = NumberFormat.getNumberInstance(locales[i]);
           nf[i * 3 +1] = NumberFormat.getNumberInstance(locales[i]);
           nf[i * 3 +2] = NumberFormat.getNumberInstance(locales[i]);
       }
       for (int i=0;i<locales.length;i++){
           String tip = i == 0 ? "--中国的格式----":
                    i ==1 ? "日本格式-- ":
                            i ==2 ? "德国的格式---":"美国格式";
           System.out.println(tip);

           System.out.println("通用数值格式：" + nf[i * 3 ].format(db));
           System.out.println("百分数值格式：" + nf[i * 3 +1].format(db));
           System.out.println("货币数值格式：" + nf[i * 3 +2].format(db));

       }
    }
}
