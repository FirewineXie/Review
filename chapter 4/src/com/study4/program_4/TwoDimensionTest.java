package com.study4.program_4;

/**
 * @Auther : xie     xyjworkgame@163.com
 * Program Name: <br>
 * @Version : 1.0
 * @Create : 2018-08-19-22:55
 */
public class TwoDimensionTest {

    public static void main(String[] args) {

        int[][] a;

        a = new int[4][];
        //把a数组当成一维数组，遍历a数组的每个数组元素
        for (int i =0;i<a.length;i++){
            System.out.println(a[i]);
        }

        //初始化a数组的第一个元素

        a[0] = new int[2];
        //访问a数组的第一个元素所指数组的第二个元素

        a[0][1] = 6;

        //a数组的第一个元素是一个一维数组，遍历
        for (int i = 0 ; i < a[0].length;i++){
            System.out.println(a[0][i]);
        }


    }
}
