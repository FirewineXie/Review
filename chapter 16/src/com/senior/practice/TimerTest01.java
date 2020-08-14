package com.senior.practice;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author : Firewine
 * @version : 1.0
 * @Program Name: TimerTest01
 * @Create : 2019/12/29
 * @Description :
 *
 *
 * Timer  也是一个线程 ，，可以有日程安排，
 * 就像是一个闹钟
 */
public class TimerTest01 {

    public static void main(String[] args) {
        // Timer timer = new Timer();
        //
        // //执行安排
        // timer.schedule(new MyTask(),1000,20);
    }
}


//任务类
class MyTask extends TimerTask{

    /**
     * The action to be performed by this timer task.
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("放空大脑");
        }
    }
}
