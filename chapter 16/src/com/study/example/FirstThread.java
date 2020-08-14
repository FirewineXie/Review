package com.study.example;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2019-01-18-15:53
 * @Description :  <br/>
 */
public class FirstThread extends Thread{

    private int i;
    //重写 run方法 ，来实现多线程的操作


    @Override
    public void run() {
        for (;i < 100 ;i++){

            //当线程继承Thread类时，直接使用this即可获取当前线程
            //Thread 对象的getName 返回当前线程的名字
            //因此可以直接调用getName方法返回当前线程的名字
            System.out.println(getName() +" " + i);

        }
    }

    public static void main(String[] args) {

        for (int i=0;i< 100;i++){
            //调用Thread的currentThread方法来获取当前线程
            System.out.println(Thread.currentThread().getName()
            + " " + i);

            if (i == 20){

                //创建第一个线程
                new FirstThread().start();
                //创建第二个线程
                new FirstThread().start();
            }
        }
    }
}
