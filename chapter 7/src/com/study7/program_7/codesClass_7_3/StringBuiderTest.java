package com.study7.program_7.codesClass_7_3;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-03-10:46
 */
public class StringBuiderTest {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        sb.append("java");
        sb.insert(0,"hello");

        sb.replace(5,6,",");
        sb.delete(5,6);

        sb.reverse();

        System.out.println(sb);

        System.out.println(sb.length());
        System.out.println(sb.capacity());


        sb.setLength(5);

        System.out.println(sb);
    }
}
