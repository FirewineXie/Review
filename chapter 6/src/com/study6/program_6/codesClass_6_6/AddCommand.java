package com.study6.program_6.codesClass_6_6;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-28-16:46
 */
public class AddCommand implements Command{
    //第二种处理行为的描述


    @Override
    public void process(int[] target) {

        int sum = 0;
        for (int tmp : target){
            sum += tmp;
        }
        System.out.println("数组元素的总和："+sum);
    }
}
