package com.study6.program_6.codesClass_6_2;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-26-22:18
 */
public class EqualTest {

    public static void main(String[] args) {

        int it = 65;
        float fl = 65.0f;

        System.out.println("65 和 65.0f 是否相等"+(it == fl));


        char ch = 'A';

        System.out.println("65 和 A 是否相等"+(it == ch));

        String str1 = new String("hello");
        String str2 = new String("hello");
        //这块，，是常量池的原因
        /*
            "hello" 和  new String ("hello")  的差别
            字符串直接量 ，这个是在编译时就计算出来的字符串量，jvm 将会使用常量池来管理这些，
            但是第二个，jvm会首先使用常量池来管理常量，在调用String 会创建一个新的String对象，
            换句话说 第二个，会一共产生两个字符串对象
         */
        System.out.println("str1 和  str2 是否相等"+(str1 == str2));

        System.out.println("str1 和 str2 是否equals相等"+ str1.equals(str2));

        //由于java.lang.String 与 Equals 类没有继承关系
        //所以下面编译错误
        //System.out.println("hello" == new EqualTest());
    }
}
