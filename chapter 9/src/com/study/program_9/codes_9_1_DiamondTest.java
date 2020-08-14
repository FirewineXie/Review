package com.study.program_9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-23-20:21
 */
public class codes_9_1_DiamondTest {

    public static void main(String[] args) {

        //java自动推荐出ArrayLIst的集合里面是什么元素类型
        List<String> books = new ArrayList<>();

        books.add("1232");
        books.add("34343");


        books.forEach(ele -> System.out.println(ele.length()));

        Map<String,List<String>> schoolInfo = new HashMap<>();

        List<String> schools = new ArrayList<>();



    }
}
