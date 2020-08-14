package com.study6.program_6.codesClass_6_6;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-28-16:44
 */
public class PrintCommand implements Command {

    //对于处理行为的描述，，不同的行为之一


    @Override
    public void process(int[] target) {
        for (int tmp : target){
            System.out.println("迭代输出目标数组的元素：" + tmp);
        }
    }
}
