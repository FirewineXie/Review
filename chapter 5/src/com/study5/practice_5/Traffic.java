package com.study5.practice_5;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-25-17:16
 */
public class Traffic {

    private String name;
    private String use;
    {
        System.out.println("都是拉送人的便捷交通工具");
    }
    public Traffic(){
        //空构造器
    }
    public  Traffic(String name){
        this.name = name;
    }
    public  Traffic(String name,String use){
        this.name = name;
        this.use = use;
    }



}
class Car extends Traffic{
    //定义三个不同构造器
}

class Train extends Traffic{
    //定义三个不同构造器
}
class Plane extends  Traffic{
    //定义三个不同构造器
}
