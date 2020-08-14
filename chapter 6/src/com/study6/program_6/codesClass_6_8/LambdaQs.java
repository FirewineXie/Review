package com.study6.program_6.codesClass_6_8;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-02-12:38
 */
interface Eatable{
    void taste();

}
interface Flyable{
    void fly(String weather);
}
interface Addable{
    int add(int a,int b);
}
public class LambdaQs {

    public void eat(Eatable e){
        System.out.println(e);
        e.taste();
    }
    public void drive(Flyable fly){
        System.out.println("我正在非=飞" + fly);
        fly.fly("天气晴朗");
    }
    public void test(Addable add){
        System.out.println("5和3相加"+add.add(5,3));
    }


    public static void main(String[] args) {


        LambdaQs lq = new LambdaQs();

        lq.eat(()-> System.out.println("苹果的味道不错"));

        lq.drive(weather -> {
            System.out.println("今天的天气是"+weather);

        });

        lq.test(((a, b) -> a+b));
        /*
            上面的代码lambda表达式实际上将会被当成一个“任意类型”的对象，到底需要当成何种类型的对象，这取决于运行环境的需要

         */
    }
}
