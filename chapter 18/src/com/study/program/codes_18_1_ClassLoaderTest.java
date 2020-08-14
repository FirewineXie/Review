package com.study.program;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-02-16:59
 */
class Tester{
    static {
        System.out.println("Tester 类的静态初始化该类");
    }

}
public class codes_18_1_ClassLoaderTest {
    public static void main(String[] args) {
        try {

            ClassLoader c1 = ClassLoader.getSystemClassLoader();
            //下面语句仅仅是加载Tester类
            c1.loadClass("Tester");

            System.out.println("系统加载Tester类");
            //下面语句才会初始化Tester类
            Class.forName("Tester");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

}
