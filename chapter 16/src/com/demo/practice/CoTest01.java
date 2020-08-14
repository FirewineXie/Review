package com.demo.practice;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: CoTest01
 * @Create : 2019/12/29
 * @Description :
 *
 * 协作模型 ： 生产者消费者实现方法——管程法
 */
public class CoTest01 {
    public static void main(String[] args) {
        Syncontainer1 container = new Syncontainer1();
        new Productor(container).start();
        new Consumer(container).start();
    }
}
//生产者
class Productor extends Thread{
    Syncontainer1 container  ;
    public Productor(Syncontainer1 container) {
        this.container = container;
    }

    @Override
    public void run() {
        //生产
        for(int i=0;i<100;i++) {
            System.out.println("生产-->"+i+"个馒头");
            container.push(new Steamedbun(i) );
        }
    }
}
//消费者
class Consumer extends Thread{
    Syncontainer1 container  ;
    public Consumer(Syncontainer1 container) {
        this.container = container;
    }
    @Override
    public void run() {
        //消费
        for(int i=0;i<100;i++) {
            System.out.println("消费-->"+container.pop().id+"个馒头");
        }
    }
}
//缓冲区
class Syncontainer1{
    Steamedbun[] buns = new Steamedbun[10]; //存储容器
    int count = 0; //计数器
    //存储 生产
    public synchronized void push(Steamedbun bun) {
        //何时能生产  容器存在空间
        //不能生产 只有等待
        if(count == buns.length) {
            try {
                this.wait(); //线程阻塞  消费者通知生产解除
            } catch (InterruptedException e) {
            }
        }
        //存在空间 可以生产
        buns[count] = bun;
        count++;
        //存在数据了，可以通知消费了
        this.notifyAll();
    }
    //获取 消费
    public synchronized Steamedbun pop() {
        //何时消费 容器中是否存在数据
        //没有数据 只有等待
        if(count == 0) {
            try {
                this.wait(); //线程阻塞  生产者通知消费解除
            } catch (InterruptedException e) {
            }
        }
        //存在数据可以消费
        count --;
        Steamedbun bun = buns[count] ;
        this.notifyAll(); //存在空间了，可以唤醒对方生产了
        return bun;
    }
}
//馒头
class Steamedbun{
    int id;
    public Steamedbun(int id) {
        this.id = id;
    }

}


