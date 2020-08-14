package com.study4.practice_4;

/**
 * @Auther : xie     xyjworkgame@163.com
 * Program Name: <br>
 * @Version : 1.0
 * @Create : 2018-08-20-18:44
 */
public class 第一题 {

    /**
     * 打印输出九九乘法表
     *
     */
    public void culmate(){

        for (int i = 1; i <= 9;i++){
            for (int j =1 ;j <= i;j++){
                System.out.print(i +" × " + j + " = " + i*j);
                System.out.printf("\t");
            }
            System.out.printf("\n");
        }
    }

    public static void main(String[] args) {
        第一题 d = new 第一题();
        d.culmate();
    }
}
