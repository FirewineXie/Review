package com.study6.program_6.codesClass_6_10;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-02-16:13
 */
public class FinalizeTest {

    private static FinalizeTest ft = null;
    public void info(){
        System.out.println("测试资源清理的Finali方法");
    }

    public static void main(String[] args) throws Exception{

        //创建FinalizeTest 对象立即进入可恢复状态
        new FinalizeTest();

        //通知系统进行资源回收
        System.gc();

        //强制垃圾回收机制调用可恢复对象的finalize方法
        //Runtime.getRuntime().runFinalization();  //这个不会立即执行，有机制会自己判断

        System.runFinalization();
        ft.info();
    }

    @Override
    protected void finalize() throws Throwable {

        ft   =this;
    }
}
