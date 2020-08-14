package com.study5.program_5.codes.program_5_8;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-22-21:06
 */
public class InheritTest {
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.breath();
        bird.fly();

        Wolf wolf = new Wolf();
        wolf.breath();
        wolf.run();
    }
}
class Animal{
    private void beat(){
        System.out.println("心脏跳动。。。。");
    }
    public void breath(){
        beat();
        System.out.println("呼吸，呼吸");
    }
}
class Bird extends Animal{

    public void fly(){
        System.out.println("我在天空自在飞翔");
    }

}
class Wolf extends Animal{

    public void run(){
        System.out.println("我在土地上奔跑");
    }

}