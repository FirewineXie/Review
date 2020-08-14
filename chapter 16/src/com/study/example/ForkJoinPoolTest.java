package com.study.example;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2019-01-18-20:02
 * @Description :  <br/>
 */
class PrintTask extends RecursiveAction{


    private static  final  int THRESHOLD = 50;
    private int start;
    private int end;

    //从打印start到end任务

    public PrintTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {

        //当start和end 中间值小于50 时，开始打印
        if (end - start < THRESHOLD){
            for (int i = start ; i< end ;i ++){
                System.out.println(Thread.currentThread().getName() + "的 i 的值   " + i);
            }
        }else {
            int middle = (start + end) / 2;
            PrintTask left = new PrintTask(start,middle);
            PrintTask right = new PrintTask(middle,end);


            left.fork();
            right.fork();
        }
    }
}
public class ForkJoinPoolTest {


    public static void main(String[] args) throws InterruptedException {

        ForkJoinPool pool =new ForkJoinPool();

        pool.submit(new PrintTask(0,300));
        pool.awaitTermination(2, TimeUnit.SECONDS);

        pool.shutdown();

    }
}
