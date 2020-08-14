package com.study6.program_6.codesClass_6_6;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-28-16:42
 */
public class CommandTest {

    public static void main(String[] args) {

        ProcessArray ps = new ProcessArray();

        int[] target = {3,-4,5,6};
        //第一次处理数组，具体处理行为取决于PrintCommand
        ps.process(target,new PrintCommand());
        System.out.println("=======================");

        //第二次处理数组
        ps.process(target,new AddCommand());

    }
}
