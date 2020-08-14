package com.study7.program_7.codesClass_7_5;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-03-14:21
 */
public class FindGroup {

    public static void main(String[] args) {

        String str = "我有一本书《封疆java》,尽快联系我13500006666"
                + "交个朋友，电话号码：13611112222"+"二手电脑：1589564589";

        Matcher m = Pattern.compile("((13\\d)|(15\\d))\\d{8}").matcher(str);

        while (m.find())
        {
            System.out.println(m.group());
        }
    }
}
