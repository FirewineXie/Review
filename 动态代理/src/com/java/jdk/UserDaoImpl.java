package com.java.jdk;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2018-12-05-19:13
 * @Description :  <br/>
 */
public class UserDaoImpl implements UserDao{
    //是以这个类作为目标类，进行增强处理
    @Override
    public void addUser() {
        System.out.println("添加用户");
    }

    @Override
    public void deleteUser() {

        System.out.println("删除用户");
    }
}
