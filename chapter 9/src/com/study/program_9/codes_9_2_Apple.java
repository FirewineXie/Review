package com.study.program_9;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-23-20:52
 */
public class codes_9_2_Apple<T> {

    //使用T类型定义实例变量
    private T info;

    public codes_9_2_Apple(){}

    //下面方法中使用T 类型来定义构造器
    public codes_9_2_Apple(T info){
        this.info = info;
    }

    public void setInfo(T info){
        this.info = info;
    }
    public  T getInfo(){
        return this.info;
    }

    public static void main(String[] args) {

        codes_9_2_Apple<String> a1 = new codes_9_2_Apple<>("苹果");

        System.out.println(a1.getInfo());

        codes_9_2_Apple<Double> a2 = new codes_9_2_Apple<>(5.69);

        System.out.println(a2.getInfo());
    }


}
