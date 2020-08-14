package com.study4.program_4;

/**
 * @Auther : xie     xyjworkgame@163.com
 * Program Name: <br>
 * @Version : 1.0
 * @Create : 2018-08-19-22:35
 */
public class ReferenceArrayTest{
    public static void main(String[] args) {

        //定义一个students数组变量，类型是Person[]
        Person[] students = new Person[2];

        //创建两个实例，并且进行赋值

        Person person1 = new Person();
        person1.age =13;
        person1.height = 154;

        Person person2 = new Person();

        person2.age = 14;
        person2.height =182;

        //将两个变量存放到数组中去

        students[0] = person1;
        students[1] = person2;


        students[0].info();
        person1.info();


    }
}
class Person{
    public int age; //年龄
    public  double height ; //身高

    //定义一个info方法
    public void  info(){
        System.out.println("我的年龄是："+age+"   。我的身高是："+height);
    }
}
