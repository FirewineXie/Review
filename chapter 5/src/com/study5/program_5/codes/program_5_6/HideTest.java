package com.study5.program_5.codes.program_5_6;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-22-16:13
 */
public class HideTest extends Parent{


    public String name = "儿子";
    public static void main(String[] args) {

        HideTest hideTest = new HideTest();
        //输出子类的name值，

        System.out.println(hideTest.name);
        //将hideTest变量强转型为parent类型的，就可以调用父类的变量
        System.out.println(((Parent)hideTest).name1);
        System.out.println(hideTest.name1);
    }

}

class Parent{
    public String name1 = "爸爸";
}
