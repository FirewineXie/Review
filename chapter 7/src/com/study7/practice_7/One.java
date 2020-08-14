package com.study7.practice_7;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-04-13:27
 */
public class One  {


    private void maxandmin(int[] sum){
        Arrays.sort(sum);

        System.out.println("max  " + sum[0]);
        System.out.println("max  " + sum[sum.length -1]);

    }

    private double average(int[] sum){
        int tmp = 0;

        for (int i =0;i<sum.length;i++){
            tmp += sum[i];
        }
        double a = tmp / sum.length;
        return a;
    }
    public static void main(String[] args) {

        int[] ints = {1,2,3,4,5,6,7,8,9,0};
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        for (int i =0;i<ints.length;i++){
//            ints[i] = a;
//        }
        One test = new One();
        test.maxandmin(ints);
        System.out.println(test.average(ints));
    }
}
