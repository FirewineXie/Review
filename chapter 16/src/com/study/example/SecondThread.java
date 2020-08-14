package com.study.example;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2019-01-18-16:02
 * @Description :  <br/>
 */
public class SecondThread implements  Runnable{

    private int i;

    /**
     * 但是从java8 开始  Runnable变成了函数式接口，就是可以lambda 进行 表达
     *  那么Callable 接口也是函数式接口
     */

    @Override
    public void run() {
        for (;i < 100 ;i++){

            //当线程继承Thread类时，直接使用this即可获取当前线程
            //Thread 对象的getName 返回当前线程的名字
            //因此可以直接调用getName方法返回当前线程的名字
            System.out.println(Thread.currentThread().getName() +" " + i);

        }
    }

    public static void main(String[] args) {

        for (int i=0;i< 100;i++){
            //调用Thread的currentThread方法来获取当前线程
            System.out.println(Thread.currentThread().getName()
                    + " " + i);

            if (i == 20){
                SecondThread st  = new SecondThread();
                //创建第一个线程
                new Thread(st,"新县城1").start();
                //创建第二个线程
                new Thread(st,"新县城2").start();
            }
        }
    }
}
