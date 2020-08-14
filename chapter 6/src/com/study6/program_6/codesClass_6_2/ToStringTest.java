package com.study6.program_6.codesClass_6_2;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-26-22:08
 */
class Apple{
    private String color;
    private double weight;

    public Apple(){

    }
    public Apple(String color,double weight){
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
//    public String toString(){
//        return "一个苹果，颜色是："+color + "重量是："+weight;
//    }

    //也可以写成
    public String toString(){
        return "Apple[color=" + color + ",weight=" + weight + "]";
    }
}
public class ToStringTest {

    public static void main(String[] args) {
        Apple apple = new Apple("红色",34);

        System.out.println(apple);
    }
}
