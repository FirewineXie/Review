package com.study5.program_5.codes.program_5_8;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-22-21:13
 */
public class CompositeTest {


    public static void main(String[] args) {

        //在这块必须要首先创建旧类的对象
        Animal animal = new Animal();

        Bird1 bird = new Bird1(animal);
        bird.breath();
        bird.fly();

        Wolf1 wolf = new Wolf1(animal);
        wolf.breath();
        wolf.run();
    }
}
class Bird1{

    //将原来的父类组合到原来的子类，作为子类的一个组合成分
    private Animal animal;
    public Bird1(Animal animal){
        this.animal = animal;
    }

    //重新定义一个breath的方法
    public void breath(){
        //直接复用Animal提供的breath方法来实现Bird的breath的方法
        animal.breath();
    }
    public void fly(){
        System.out.println("我在天空自在飞翔");
    }
}
class Wolf1{
    private Animal animal;
    public Wolf1(Animal animal){
        this.animal = animal;
    }
    public void breath(){
        animal.breath();
    }

    public void run(){
        System.out.println("我在田野上奔跑");
    }

}
