package com.study6.program_6.codesClass_6_6;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-28-16:37
 */
public interface Command {

    //接口里定义的process方法用于封装"处理行为"
    void process(int[] target);
    //没有方法体，是因为你还不能确定行为是什么
}
