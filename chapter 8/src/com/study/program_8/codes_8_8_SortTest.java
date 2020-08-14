package com.study.program_8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-23-14:02
 */
public class codes_8_8_SortTest {

    public static void main(String[] args) {

        ArrayList nums = new ArrayList();

        nums.add(2);
        nums.add(-2);
        nums.add(3);
        nums.add(6);


        System.out.println(nums);

        Collections.reverse(nums);

        System.out.println(nums);

        Collections.sort(nums);

        System.out.println(nums);

        Collections.shuffle(nums);

        System.out.println(nums);
    }
}
