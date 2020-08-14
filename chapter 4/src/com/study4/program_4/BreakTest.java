package com.study4.program_4;

/**
 * @Auther : xie     xyjworkgame@163.com
 * Program Name: <br>
 * @Version : 1.0
 * @Create : 2018-08-19-16:17
 */
public class BreakTest {

    public static void main(String[] args) {

        for (int i= 0; i < 10; i++){
            System.out.println("i 的值：" + i);
            if(i == 2){
                break;
            }
        }
    }
}
