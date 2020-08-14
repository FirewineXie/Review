package com.study4.program_4;

import java.util.Arrays;

/**
 * @Auther : xie     xyjworkgame@163.com
 * Program Name: <br>
 * @Version : 1.0
 * @Create : 2018-08-20-11:05
 */
public class ArraysTest {
    public static void main(String[] args) {

        int[] a1 = new int[]{3,4,5,6};

        int[] a2 = new int[] {3,4,5,6};

        //通过判断a1和a2 的长度和数组元素判断数组是否相等

        System.out.println("a1  和 a2 是否相等："+ Arrays.equals(a1, a2));

        //通过复制a1数组，生成一个新的数组b

        int[] b = Arrays.copyOf(a1,6);
        System.out.println("a1 和 b  数组是否相等："+ Arrays.equals(a1,b));

        //将b的数组输出为字符串的形式
        System.out.println("将b数组输出字符串的形式：" + Arrays.toString(b));


        //将数组b的后面第三个元素到第五个元素赋值为1
        Arrays.fill(b,3,5,1);
        System.out.println("已经赋值，，打印b的数组元素："+Arrays.toString(b));


        //对数组b进行排序
        Arrays.sort(b);

        System.out.println("输出排序后的b的数组元素：" + Arrays.toString(b));

    }
}
