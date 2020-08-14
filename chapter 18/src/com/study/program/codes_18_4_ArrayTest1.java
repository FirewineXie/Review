package com.study.program;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-05-17:23
 */
public class codes_18_4_ArrayTest1 {

    public static void main(String[] args) {

        try{
            //创建一个元素类型为string 长度为10 的数组
            Object arr = Array.newInstance(String.class , 10);

            //依次为arr 数组中index 为6,5 的元素赋值
            Array.set(arr,5,"java讲义");
            Array.set(arr,6,"13");
            //依次取出上面赋值的
            Object book1 = Array.get(arr,5);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
