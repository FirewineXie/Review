package com.study4.program_4;

/**
 * @Auther : xie     xyjworkgame@163.com
 * Program Name: <br>
 * @Version : 1.0
 * @Create : 2018-08-19-16:19
 */
public class BreakTest2 {

    public static void main(String[] args) {

        outer:
        for (int i =1; i <10; i ++){
            for (int j =0;j<5;j++){
                System.out.println("i 的值 ： " + i + "j 的值： " + j);
                if (j ==4){
                    break outer;
                }
            }
        }
    }
}
