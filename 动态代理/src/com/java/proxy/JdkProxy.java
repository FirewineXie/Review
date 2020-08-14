package com.java.proxy;

import com.java.aspect.MyAspect;
import com.java.jdk.UserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2018-12-05-19:17
 * @Description :  <br/>
 */
public class JdkProxy implements InvocationHandler {

    //声明目标类接口
    private UserDao userDao;

    //创建代理方法
    public Object createProxy(UserDao userDao){
        this.userDao = userDao;

        //1. 类加载器
        ClassLoader classLoader = JdkProxy.class.getClassLoader();

        //2. 被代理对象实现的所有接口
        Class[] classes = userDao.getClass().getInterfaces();

        //3. 使用代理类，进行增强，返回的是代理后的对象
        return Proxy.newProxyInstance(classLoader,classes,this::invoke);
    }


    /**
     * 所有的动态代理类的方法调用，都会交由invoke方法去处理
     * @param proxy  就是被代理后的对象
     * @param method 是要执行的方法(反射)
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /**
         * 第一个参数 ： 当前类的类加载器
         * 第二个参数 ： 是被代理对象实现的所有的接口
         * 第三个参数 ： 代表代理类JdkProxy的本身
         */

        //声明切面
        MyAspect myAspect  = new MyAspect();
        //前增强
        myAspect.check_Permissions();
        //在目标类上调用方法，传入参数
        Object obj = method.invoke(userDao,args);
        //后增强
        myAspect.log();
        return obj;
    }
}
