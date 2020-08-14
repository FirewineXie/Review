package com.study5.program_5.codes.program_5_4;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-22-13:29
 */
public class PersonTest {

    public static void main(String[] args) {
        Person person = new Person();

        //person.age  这个就是错误的因为这个变量已经隐藏了
        person.setAge(99);
        person.setName("李刚");
    }
}
