package com.senior.practice;

/**
 * @author : Firewine
 * @version : 1.0
 * @Program Name: DoubleCheckedLocking
 * @Create : 2019/12/29
 * @Description :
 * <p>
 * 单例模式： 懒汉式套路，在多线程环境下，对外存在一个对象
 * 1. 构造器私有化 - -》 避免外部new 构造器
 * 2. 提供私有的静态属性 --》 存储对象的地址
 * 3. 提供公共的静态方法 --》 获取属性
 */
public class DoubleCheckedLocking {

    //2. 提供私有的静态属性 --》 存储对象的地址
    /**
     * 这里如果直接new对象了，则成为饿汉式
     * 如果像这样没有new对象，则为懒汉式
     */
    private static volatile  DoubleCheckedLocking instancel;


    //1. 构造器私有化 - -》 避免外部new 构造器
    private DoubleCheckedLocking() {

    }

    //3.提供公共的静态方法 --》 获取属性
    public static DoubleCheckedLocking getInstance() {
    //没有volatile 其他线程可能获取空的引用
        //再次检测
        if (null != instancel) {
            //避免不必要的同步，已经存在对象
            return instancel;
        }
        synchronized (DoubleCheckedLocking.class) {
            if (null == instancel) {
                instancel = new DoubleCheckedLocking();
                //1. 开辟空间
                // 2. 初始化对象信息
                // 3. 返回对象的地址给引用
            }
        }
        return instancel;
    }


    public static void main(String[] args) {
        Thread t = new Thread(()->{
            System.out.println(DoubleCheckedLocking.getInstance());
        });

        t.start();
        System.out.println(DoubleCheckedLocking.getInstance());
    }
}
