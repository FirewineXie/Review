package com.study5.program_5;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-21-21:36
 */
public class Recursive {

    public static int fn(int n){

        if (n == 0){
            return 1;
        }else if(n ==1){
            return 4;
        }else {
            //fn(n +2) - 2 * fn(n+1) 这种是错误的
            return 2 *fn(n - 1) + fn(n -2);
        }
    }

    public static void main(String[] args) {
        System.out.println(fn(4));
    }
}
