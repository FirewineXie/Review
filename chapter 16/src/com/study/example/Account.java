package com.study.example;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2019-01-18-17:28
 * @Description :  <br/>
 */
public class Account {
    //模拟取钱的操作使用 锁

    //定义锁对象
    private final ReentrantLock lock = new ReentrantLock();

    //封装 账号编号，余额
    private String acountNo;
    private double balance;

    public Account(String acountNo, double balance) {
        this.acountNo = acountNo;
        this.balance = balance;
    }

    public String getAcountNo() {
        return acountNo;
    }

    public void setAcountNo(String acountNo) {
        this.acountNo = acountNo;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * 使用锁来保证数据的正确性
     * @param drawAmount
     */
    public void draw(double drawAmount) {
        lock.lock();

        try {
            if (balance >= drawAmount) {
                System.out.println(Thread.currentThread().getName() + "取钱    " + drawAmount);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                balance -= drawAmount;

                System.out.println("余额 ；" + balance);
            } else {
                System.out.println("取钱失败");
            }
        } finally {
            lock.unlock();
        }
    }
}
