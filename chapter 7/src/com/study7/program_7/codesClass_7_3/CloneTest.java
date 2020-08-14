package com.study7.program_7.codesClass_7_3;

import javax.jws.soap.SOAPBinding;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-03-10:34
 */
class Address{
    String detail;
    public Address(String detail){
        this.detail = detail;
    }
}
//实现cloneable的接口
class User implements Cloneable{
    int age;
    Address address;

    public User(int age){
        this.age = age;
        address = new Address("天河");
    }

    //通过调用super。clone来实现clone方法
    public User clone() throws CloneNotSupportedException{
      return (User)super.clone();
    }
}
public class CloneTest {

    public static void main(String[] args)throws CloneNotSupportedException {
        User u1 = new User(29);
        //clone得到u1对象的副本
        User u2 = u1.clone();

        System.out.println(u1 == u2);

        System.out.println(u1.address == u2.address);
    }
}
