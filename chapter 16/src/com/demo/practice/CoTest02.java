package com.demo.practice;

/**
 * @author : Firewine
 * @version : 1.0
 * @Program Name: CoTest02
 * @Create : 2019/12/29
 * @Description :
 *
 * 信号灯的方法，来描述并发协作
 */
public class CoTest02 {


    public static void main(String[] args) {
        Tv tv = new Tv();

        new Player(tv).start();
        new Watcher(tv).start();
    }
}


//生产者 演员
class Player extends Thread{
    Tv tv;

    public Player(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {

        for (int i = 0 ; i< 20 ;i++){
            if (i % 2 == 0) {
                this.tv.play("奇葩说");
            }else{
                this.tv.play("不想说话");
            }
        }
    }
}
// 消费者 观众
class Watcher  extends Thread{

    Tv tv;

    public Watcher(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i=0;i < 20;i++){

            tv.watch();
        }
    }
}
//同一个资源 电视
class Tv{

    String voice;
    //信号灯
    //T 表示演员表演，观众等待
    //F 表示观众观看， 演员等待
    Boolean flag = true;


    //表演
    public synchronized void play(String voice ){

        //演员等待
        if (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //等到了，然后唤醒
        System.out.println("表演了         "+ voice);
        this.voice = voice;

        this.notifyAll();
        this.flag  = !this.flag;
    }

    //观看
    public synchronized void watch() {

        //观众等待
        if (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //表演过后，开始观看

        System.out.println("听到了  " + voice);

        this.notifyAll();
        this.flag  = !this.flag;
    }
}
