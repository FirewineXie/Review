package com.cglib.test;

import com.cglib.jdk.UserDao;
import com.cglib.proxy.CglibProxy;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2018-12-05-19:49
 * @Description :  <br/>
 */
public class CglibTest {
    public static void main(String[] args) {


        CglibProxy cglibProxy = new CglibProxy();

        UserDao userDao = new UserDao();


        UserDao userDao1 = (UserDao) cglibProxy.CreateProxy(userDao);

        userDao1.addUser();
        userDao1.deleteUser();
    }
}
