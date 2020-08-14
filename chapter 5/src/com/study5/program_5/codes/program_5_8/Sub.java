package com.study5.program_5.codes.program_5_8;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-22-20:59
 */
public class Sub extends Base{

    private String name;

    @Override
    public void test() {
        System.out.println("子类重写父类的方法，"+"其name的名字："+name);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
    }
}
class Base{
    public Base(){
        test();
    }
    public void test(){
        System.out.println("将被子类重写的方法");
    }
}