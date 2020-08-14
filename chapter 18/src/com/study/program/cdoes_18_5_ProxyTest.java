package com.study.program;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-07-14:49
 */
interface Person{
    void walk();
    void sayHello(String name);
}
class MyInvokationHandle implements InvocationHandler{

    /**
     * 执行动态代理对象的所有方法时，都会被替换成执行如下的invoke方法
     * 其中；
     * @param proxy  代表动态代理对象
     * @param method 代表正在执行的方法
     * @param args 代表调用目标时传入的实参
     * @return
     * @throws Throwable
     */

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("------正在执行的方法：" + method);
        if (args != null){
            System.out.println("下面是执行该方法时传入的实参：");
            for (Object val :args){
                System.out.println(val);
            }
        }else {
            System.out.println("调用该方法没有实参");
        }


        return null;
    }

}
public class cdoes_18_5_ProxyTest  {




    public static void main(String[] args) {

        //创建一个InvocationHandle 对象
        InvocationHandler handler = new MyInvokationHandle();
        //使用指定的InvocationHandle 来生成一个动态代理对象

        Person p = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(),
                new Class[]{Person.class},handler);

        //调用动态代理对象的walk 和sayHello方法
        p.walk();
        p.sayHello("sunkongkong ");
    }
}
