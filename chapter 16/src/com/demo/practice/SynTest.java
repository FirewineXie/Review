package com.demo.practice;

/**
 * @author : Firewine
 * @version : 1.0
 * @Program Name: SynTest
 * @Create : 2019/12/28
 * @Description :
 */
public class SynTest {


    /**'
     * 线程安全，保证数据的正确性，同时效率的尽可能的高
     * 所以 Syncronized  不可能太大，和太小
     */

    public static void main(String[] args) {
        UnsafeWeb123061 web12306 = new UnsafeWeb123061();

        //多个代理
        new Thread(web12306, "码1").start();
        new Thread(web12306, "码2").start();
        new Thread(web12306, "码3").start();
    }
}
class UnsafeWeb123061 implements Runnable {


    //票数
    private int ticketNums = 100;

    @Override
    public  void run() {

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
        }}
    }
