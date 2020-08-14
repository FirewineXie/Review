package com.demo.practice;

/**
 * @author : Firewine
 * @version : 1.0
 * @Program Name: Unsafe
 * @Create : 2019/12/28
 * @Description :
 * 线程不安全，出现 重复 和负数等
 */
public class Unsafe {



    public static void main(String[] args) {

        UnsafeWeb12306 web12306 = new UnsafeWeb12306();

        //多个代理
        new Thread(web12306, "码1").start();
        new Thread(web12306, "码2").start();
        new Thread(web12306, "码3").start();

    }

}
class UnsafeWeb12306 implements Runnable{


    //票数
    private int ticketNums = 10;
    @Override
    public void run() {
        while (true) {
            if (ticketNums < 0) {
                break;
            }


            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
        }
    }
}