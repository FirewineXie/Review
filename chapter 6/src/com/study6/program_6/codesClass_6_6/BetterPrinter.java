package com.study6.program_6.codesClass_6_6;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-28-15:45
 */
public class BetterPrinter implements Output {
    /**
     * 模拟系统重构的改进
     *
     */

    private String[] printdata = new String[MAX_CACHE_LINE];

    private int dataNum = 0;

    @Override
    public void out() {
        while (dataNum > 0){
            System.out.println("高速打印机打印"+printdata[0]);
            System.arraycopy(printdata,1,printdata,0,--dataNum);
        }
    }

    @Override
    public void getData(String msg) {

        if (dataNum >= MAX_CACHE_LINE * 2){
            System.out.println("输出队列已满，添加失败");
        }else {
            printdata[dataNum++] = msg;
        }
    }
}
