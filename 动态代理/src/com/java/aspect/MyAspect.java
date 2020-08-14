package com.java.aspect;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2018-12-05-19:15
 * @Description :  <br/>
 */
public class MyAspect {

    //下面两个方法模拟切面
    /**
     * 模拟权限检查方法
     */
    public void check_Permissions(){
        System.out.println("权限检查");
    }

    /**
     * 模拟日志方法
     */
    public void log(){
        System.out.println("记录日志");
    }
}
