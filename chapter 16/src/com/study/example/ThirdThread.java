package com.study.example;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2019-01-18-16:44
 * @Description :  <br/>
 */
public class ThirdThread {

    public static void main(String[] args) {

        //创建 Callable 对象
        ThirdThread rt = new ThirdThread();

        //使用lambda 来创建对象
        FutureTask<Integer> task = new FutureTask<>((Callable<Integer>)() ->{

            int i=0;
            for(; i < 100; i++){
                System.out.println(Thread.currentThread().getName() + "的循环变量i的值： " + i);

            }
            return i;
        });

        for (int i=0;i <100 ;i++){
            System.out.println(Thread.currentThread().getName() + "循环变量i的值：  "+ i);
            if (i ==20){
                new Thread(task ,"有返回值的线程").start();
            }
        }
        try {
            System.out.println("线程返回的值 ： "  + task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
