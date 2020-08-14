package com.study.jdk_动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-07-14:03
 */
public class InvocationHandlerImpl implements InvocationHandler {

    /**
     * 这个就是代理的真实对象
     */
    private Object subject;


    /**
     * 构造方法，给代理的真实对象赋值
     * @param subject
     */
    public InvocationHandlerImpl(Object subject){

        this.subject = subject;
    }


    /**
     * 该方法负责几种处理动态代理类上的所有方法调用
     * 调用处理器根据这三个阐述进行预处理成分到委托类实例上反射执行
     * @param proxy 代理类实例
     * @param method 被调用的方法对象
     * @param args 调用参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("在调用之前，我要干点啥？");

        System.out.println("Method: " + method);



        //当代理对象调用真实对象的方法时，其会自动的跳转到代理对象管理的handler 对象的invoke方法

        Object returnValue = method.invoke(subject,args);
        //在代理真实对象后我们也可以添加一些自己的操作

        System.out.println("在调用之后");
        return returnValue;
    }
}
