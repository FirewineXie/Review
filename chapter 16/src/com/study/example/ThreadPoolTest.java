package com.study.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2019-01-18-19:54
 * @Description :  <br/>
 */
public class ThreadPoolTest {

    public static void main(String[] args) {

        //创建一个固定线程 数6 的线程池
        ExecutorService pool = Executors.newFixedThreadPool(6);
        //使用lambda 创建Runnable 对象

        Runnable target = () -> {
            for (int i=0; i < 100; i++){
                System.out.println(Thread.currentThread().getName() + "的 i的值  " + i);
            }
        };


        pool.submit(target);
        pool.submit(target);


        pool.shutdown();
    }
}
