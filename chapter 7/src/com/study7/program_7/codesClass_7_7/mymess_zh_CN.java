package com.study7.program_7.codesClass_7_7;

import java.util.ListResourceBundle;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-04-11:09
 */
public class mymess_zh_CN extends ListResourceBundle {

    //定义资源
    private final Object myData[][] ={
            {"msg","{0},你好！111  ，今日期是{1}"}
    };

    //重写getContents方法
    public Object[][] getContents(){
        return myData;
    }
}
