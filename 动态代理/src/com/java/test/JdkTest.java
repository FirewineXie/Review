package com.java.test;

import com.java.jdk.UserDao;
import com.java.jdk.UserDaoImpl;
import com.java.proxy.JdkProxy;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2018-12-05-19:25
 * @Description :  <br/>
 */
public class JdkTest {

    public static void main(String[] args) {

        //创建代理对象
        JdkProxy jdkProxy = new JdkProxy();

        //创建目标对象
        UserDao userDao = new UserDaoImpl();

        //从代理对象获取增强后的目标对象
        UserDao userDao1 = (UserDao) jdkProxy.createProxy(userDao);


        userDao1.addUser();
        userDao1.deleteUser();
    }
}
