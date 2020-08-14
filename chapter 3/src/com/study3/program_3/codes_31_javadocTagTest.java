package com.study3.program_3;

/**
 * @Auther : xie     xyjworkgame@163.com
 * Program Name: <br>
 * @Version : 1.0
 * @Create : 2018-08-19-12:20
 */
public class codes_31_javadocTagTest {
    /**
     *  一个得到打招呼字符串的方法
     * @param name 该参数指定向谁打招呼
     * @return  返回打招呼的字符串
     */
    public String hello(String name){
        return name + "你好";
    }
}
/*
        javadoc 的标记如下：
            @auther 指定java程序的作者
            @version 指定源文件的版本
            @deprecated 不推荐使用的方法
            @param 方法的参数说明信息
            @return 方法的返回值说明信息
            @see  “参见”，用于指定交叉参考的内容
            @exception 抛出异常的类型
            @throws 抛出的异常，和exception同义
          但是上述的标记的使用是有位置限制的，
 */
