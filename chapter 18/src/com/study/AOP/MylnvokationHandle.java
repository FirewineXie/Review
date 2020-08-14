package com.study.AOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-07-16:40
 */
public class MylnvokationHandle implements InvocationHandler {


    //需要被代理的对象
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    //执行动态代理对象的所有方法时，都会被替换成如下的invoke 方法

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        DogUtil du = new DogUtil();
        //执行DogUtil对象的method1 方法
        du.method1();;

        //以target 作为主调来执行method方法
        Object result = method.invoke(target,args);
        /**
         * 这行代码通过反射一target 作为主调来执行method 方法，这就是回调了target 对象的原有方法。
         */

        //执行DogUtil 对象中的method2 方法
        du.method2();
        return result;
    }
}
