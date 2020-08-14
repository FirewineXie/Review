package com.study5.program_5.codes.program_5_6;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-22-16:10
 */
public class SubClass extends Base {

    public int a = 7;

    public void asccessOwner(){
        System.out.println(a);
    }

    public void accessBase(){
        //调用父类的a的变量
        System.out.println(super.a);
    }

    public static void main(String[] args) {

        SubClass subClass = new SubClass();

        subClass.accessBase();
        subClass.asccessOwner();
    }
}

class Base{
    public int a = 5;
}
