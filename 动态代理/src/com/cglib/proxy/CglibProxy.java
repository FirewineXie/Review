package com.cglib.proxy;


import com.java.aspect.MyAspect;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2018-12-05-19:36
 * @Description :  <br/>
 */
public class CglibProxy implements MethodInterceptor {

    public Object CreateProxy(Object object){
        //创建一个动态类对象
        Enhancer enhancer = new Enhancer();
        //确定需要增强的类，设置其父类
        enhancer.setSuperclass(object.getClass());

        //添加回调函数
        enhancer.setCallback( this);
        //返回创建的代理类
        return enhancer.create();
    }

    /**
     * proxy CGLIB 根据指定父类生成的代理对象
     * method 拦截的方法
     * args 拦截方法的参数数组
     * methodProxy 方法的代理对象，用于执行父类的方法
     * @param
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //创建切面类对象
        MyAspect myAspect = new MyAspect();

        myAspect.check_Permissions();

        Object object = methodProxy.invokeSuper(methodProxy,objects);

        myAspect.log();
        return object;
    }
}
