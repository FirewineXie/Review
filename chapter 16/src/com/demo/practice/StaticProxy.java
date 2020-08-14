package com.demo.practice;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: StaticProxy
 * @Create : 2019/12/27
 * @Description :  静态代理设计模式
 */
public class StaticProxy {


    /**
     * 静态代理 ：
     * 接口 ：
     * 1. 真实角色
     * 2. 代理角色
     */


    public static void main(String[] args) {
        new WeddingCompany(new You()).happyMarry();


    }
}

interface Marry {
    void happyMarry();
}

//真实角色
class You implements Marry {

    @Override
    public void happyMarry() {
        System.out.println("你和  ddd  本月");
    }

}

//代理角色
class WeddingCompany implements Marry {

    //真实角色
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        ready();
        this.target.happyMarry();
        after();
    }

    private void after() {
        System.out.println("撤退");
    }

    private void ready() {
        System.out.println("布置");
    }

}
