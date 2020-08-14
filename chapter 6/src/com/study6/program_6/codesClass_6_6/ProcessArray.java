package com.study6.program_6.codesClass_6_6;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-28-16:39
 */
public class ProcessArray {
    //创建一个Command参数，去负责行为

    public void process(int[] target,Command cmd){
        cmd.process(target);
        /**
         * 通过一个command的接口实现让这个类与具体处理行为的分离。
         * 程序使用command接口代表对数组的处理行为。
         */
    }
}
