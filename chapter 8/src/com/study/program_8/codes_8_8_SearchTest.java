package com.study.program_8;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-23-16:16
 */
public class codes_8_8_SearchTest {

    public static void main(String[] args) {

        ArrayList nums = new ArrayList();
        nums.add(2);
        nums.add(3);
        nums.add(-3);
        nums.add(0);

        System.out.println(nums);

        System.out.println(Collections.max(nums));

        System.out.println(Collections.min(nums));

        Collections.replaceAll(nums,0,1);
        System.out.println(nums);


        System.out.println(Collections.frequency(nums,-5));

        Collections.sort(nums);

        System.out.println(nums);

        //只有排序后的list集合才可以使用二分法，
        System.out.println(Collections.binarySearch(nums,3));
    }
}
