package com.study.program_8;

import java.net.CookieHandler;
import java.util.*;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-23-16:21
 */
public class codes_8_8_SynchronizedTest {

    public static void main(String[] args) {

        Collections c = (Collections) Collections.synchronizedCollection(new ArrayList());

        List list = Collections.synchronizedList(new ArrayList());

        Set s = Collections.synchronizedSet(new HashSet<>());

        Map m  = Collections.synchronizedMap(new HashMap<>());
    }
}
