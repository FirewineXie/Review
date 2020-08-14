package com.study4.program_4;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

/**
 * @Auther : xie     xyjworkgame@163.com
 * Program Name: <br>
 * @Version : 1.0
 * @Create : 2018-08-20-11:33
 */
public class ArraysTest2 {

    public static void main(String[] args) {

        int[] arr1 = new int[]{3,-4,25,16,30,18};

        //对数组Arr1进行并发排序
        Arrays.parallelSort(arr1);

        System.out.println(Arrays.toString(arr1));

        int[] arr2 = new int[]{3,-4,25,16,30,18};

        Arrays.parallelPrefix(arr2, new IntBinaryOperator() {
            /**
             *
             * @param left  代表数组中前一个元素，计算第一个元素时，值为1
             * @param right 代表数组中当前索引处的元素
             * @return
             */
            @Override
            public int applyAsInt(int left, int right) {

                return left * right;
            }
        });

        System.out.println(Arrays.toString(arr2));


        int[] arr3 = new int[5];

        Arrays.parallelSetAll(arr3, new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {

                //operand  代表计算的索引
                return operand + 5;
            }
        });

        System.out.println(Arrays.toString(arr3));
    }
}
