package com.study.program_8;

import java.util.HashMap;
import java.util.Map;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-23-11:03
 */
public class codes_8_6_MapTest {

    public static void main(String[] args) {

        Map map = new HashMap();

        map.put("java1",194);
        map.put("java2",20);
        map.put("java3",59);


        System.out.println(map.put("java3",59));

        System.out.println(map);//输出map集合

        System.out.println("是否包含java2"+map.containsKey("java2"));

        System.out.println("是否包含值20" +map.containsValue(20));

        //遍历输出数组
        for (Object key : map.keySet()){
            System.out.println(key + "-->" + map.get(key));
        }

        HashMap hm = new HashMap();

        hm.put(null,null);
        hm.put(null,null);

        hm.put("a",null);

        System.out.println(hm);

    }
}