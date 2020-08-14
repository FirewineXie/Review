package com.study.program;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-05-16:26
 */
public class codes_18_4_CreateJFrame {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        //获取JFrame 对应的Class对象
        Class<?> jframeClazz = Class.forName("javax.swing.JFrame");
        //获取JFrame 中带一个字符串参数的构造器

        Constructor ctor = jframeClazz.getConstructor(String.class);

        //调用Constructor的newInstance方法创建对象
        Object obj = ctor.newInstance("测试窗口");

        System.out.println(obj);
    }
}
