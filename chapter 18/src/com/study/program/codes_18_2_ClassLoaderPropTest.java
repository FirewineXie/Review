package com.study.program;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-02-17:13
 */
public class codes_18_2_ClassLoaderPropTest {

    public static void main(String[] args)throws IOException {

        //获取系统类加载器
        ClassLoader systemLoader = ClassLoader.getSystemClassLoader();

        System.out.println("系统类加载器：" + systemLoader);

        /**
         * 获取系统类加载器的加载路径---通常由CLASSPATH环境变量指定的
         * 如果操作系统没有指定CLASSPATH 环境变量，则默认当前的路径为系统类加载器的加载路径
         */

        Enumeration<URL> em1 = systemLoader.getResources("");
        while (em1.hasMoreElements()){
            System.out.println(em1.nextElement());
        }

        //获取系统类加载器的父类加载器，得到扩展类的加载器
        ClassLoader extensionLader = systemLoader.getParent();
        System.out.println("扩展类加载器；"+extensionLader);

        System.out.println("扩展类加载器的加载路径：" + System.getProperty("java.ext.dirs"));

        System.out.println("扩展类加载器的parent：" + extensionLader.getParent());
    }
}
