package com.study6.program_6.codesClass_6_9;

import static com.study6.program_6.codesClass_6_9.SeasonEnum.*;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-02-14:28
 */
public class EnumTest {

    public void judge(SeasonEnum s){
        switch (s){
            case SPRING:
                System.out.println("春");
                break;
            case SUMMER:
                System.out.println("夏");
                break;
            case FALL:
                System.out.println("秋");
                break;
            case WINTER:
                System.out.println("冬");
                break;

        }
    }

    public static void main(String[] args) {

        for (SeasonEnum s : SeasonEnum.values()){
            System.out.println(s);
        }

        //使用枚举实例时，可通过EnumClass。Variable形式来访问
        new EnumTest().judge(SeasonEnum.SPRING);
    }
}
