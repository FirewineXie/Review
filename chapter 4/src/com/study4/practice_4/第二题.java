package com.study4.practice_4;

/**
 * @Auther : xie     xyjworkgame@163.com
 * Program Name: <br>
 * @Version : 1.0
 * @Create : 2018-08-20-18:49
 */
public class 第二题 {
    /**
     * 循环输出等腰三角形，
     * @param n ： 输入的行数
     */
    public void printP(int n){
        System.out.println("输入1o以内的数字，才可以合理运行");

        for (int i = 0;i<n;i++){
            /**
             * 打印空格
             */
            for (int j = 10;j>i;j--){
                System.out.printf(" ");
            }
            for (int k =0 ; k<= i;k++){
                System.out.printf("*");
            }
            for (int m=0;m<i;m++){
//                System.out.printf("           ");
                System.out.printf("*");
            }
            System.out.printf("\n");
        }
    }

    public static void main(String[] args) {
        第二题 d = new 第二题();
        d.printP(4);
    }
}
