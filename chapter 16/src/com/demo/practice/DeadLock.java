package com.demo.practice;

/**
 * @author : Firewine
 * @version : 1.0
 * @Program Name: DeadLock
 * @Create : 2019/12/28
 * @Description :
 *
 * 死锁 ： 多个线程各自占有一些共享资源，并且互不相让，而导致
 * 多个线程都在等待资源，然后同时停止执行的情况
 */
public class DeadLock {

    public static void main(String[] args) {
        Markup g1 = new Markup(1,"张柏芝");
        Markup g2 = new Markup(0,"王菲");
        g1.start();
        g2.start();
    }

}
//口红
class Lipstick{

}
//镜子
class Mirror{

}
//化妆
class Markup extends Thread{
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();
    //选择
    int choice;
    //名字
    String girl;
    public Markup(int choice,String girl) {
        this.choice = choice;
        this.girl = girl;
    }

    @Override
    public void run() {
        //化妆
        markup();
    }
    //相互持有对方的对象锁-->可能造成死锁
    private void markup() {
        if(choice==0) {
            synchronized(lipstick) { //获得口红的锁
                System.out.println(this.girl+"涂口红");
                //1秒后想拥有镜子的锁
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
				/*
				synchronized(mirror) {
					System.out.println(this.girl+"照镜子");
				}*/
            }
            synchronized(mirror) {
                System.out.println(this.girl+"照镜子");
            }
        }else {
            synchronized(mirror) { //获得镜子的锁
                System.out.println(this.girl+"照镜子");
                //2秒后想拥有口红的锁
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
					/*
					synchronized(lipstick) {
						System.out.println(this.girl+"涂口红");
					}	*/

            }
            synchronized(lipstick) {
                System.out.println(this.girl+"涂口红");
            }
        }
    }
}
