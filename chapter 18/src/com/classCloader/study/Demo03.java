package com.classCloader.study;

/**
 * @author : Firewine
 * @version : 1.0
 * @Program Name: Demo03
 * @Create : 2020/1/15
 * @Description :
 */
public class Demo03 {


    public static void main(String[] args) throws ClassNotFoundException {

        FileSystemClassLoader loader = new FileSystemClassLoader("D:/myjava");

        Class<?> c = loader.loadClass("com.classCloader.study.HelloWorld");

        System.out.println(c);
    }
}
