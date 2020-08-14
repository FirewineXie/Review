package com.study.AOP;

import java.lang.reflect.Proxy;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-07-16:54
 */
public class MyProxyFactory {

    //为指定的target 生成动态代理对象
    public static Object getProxy(Object target){
        //创建一个MyInvokationHandle 对象

        MylnvokationHandle handle = new MylnvokationHandle();

        //为MyInvokationHandle 设置target 对象
        handle.setTarget(target);
        //返回一个动态代理
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),handle);
    }
}
