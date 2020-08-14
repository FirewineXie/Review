package com.study7.program_7.codesClass_7_7;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-04-10:49
 */
public class Hello {

    public static void main(String[] args) {
        //获得系统默认的语言环境
        Locale locales = Locale.getDefault(Locale.Category.FORMAT);

        //根据系统环境来加载资源文件
        ResourceBundle bundle = ResourceBundle.getBundle("mess",locales);
        System.out.println(bundle.getString("hello"));
    }
}
