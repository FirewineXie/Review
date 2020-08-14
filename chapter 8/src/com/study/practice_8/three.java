package com.study.practice_8;

import java.util.HashMap;
import java.util.Map;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-23-17:11
 */
public class three {

    public static void main(String[] args) {


        Map map = new HashMap();
        map.put("a", 0);
        map.put("b", 0);
        map.put("c", 0);
        String[] tmp = {"a", "b", "a", "b", "c", "a", "b", "c", "b"};

        for (String tmps : tmp) {
            if (map.containsKey(tmps)) {
                 map.put(tmps, ((int)map.get(tmps)+1));
            }
        }

        System.out.println(map);
    }
}
