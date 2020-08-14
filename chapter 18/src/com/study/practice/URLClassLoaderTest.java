package com.study.practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-03-15:08
 */
public class URLClassLoaderTest {

    public static  void demo(String name) throws MalformedURLException, IllegalAccessException, InstantiationException {

        URL[] urls = {new URL("file:com.study.program.hello")};

        URLClassLoader myClassLoader = new URLClassLoader(urls).getClass().newInstance();


        System.out.println(myClassLoader.toString());



    }

    public static void main(String[] args) throws MalformedURLException, InstantiationException, IllegalAccessException {
        URLClassLoaderTest.demo("1");
    }
}
