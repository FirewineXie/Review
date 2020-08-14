package com.study6.program_6.codesClass_6_7;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-02-10:51
 */
class StaticOut{
    //定义一个静态内部类，不使用访问控制符
    //即同一个包中的其他类可访问该内部类

    static class StaticIn{
        public StaticIn(){
            System.out.println("静态内部类的构造器");
        }
    }
}
public class CreatsStaticlnnerInstance {

    public static void main(String[] args) {
        StaticOut.StaticIn in = new StaticOut.StaticIn();

        /*
            上面的代码可以改为如下的代码：
            使用OutClass。InnerClass 的形式定义内部类变量
            StaticOut.staticin in;
            通过new 来调用内部类构造器创建静态内部类的实例
            in = new StaticOut.staticin()
         */
    }
}
