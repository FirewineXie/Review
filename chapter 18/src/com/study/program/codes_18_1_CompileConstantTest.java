package com.study.program;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-02-16:26
 */
class MyTest{

    static {
        //初始化快
        System.out.println("静态初始化快。。。");
    }
    static final String compileConstant = "This is a begin";
}

public class codes_18_1_CompileConstantTest {

    public static void main(String[] args) {

        System.out.println(MyTest.compileConstant);

        //上面定义的compileConstant 类变量的值 必须在运行时才可以确定，，所以要通过类变量去使用，，这将导致被实例化，


    }


}
