package com.study7.program_7.codesClass_7_2;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-02-18:16
 */
public class SystemTest {


    public static void main(String[] args)throws Exception {

        System.out.println(System.getenv("JAVA_HOME"));
        System.out.println(System.getProperties());

        Runtime r  =  Runtime.getRuntime();
        System.out.println("处理器数量："+r.availableProcessors());

        System.out.println("最大内存："+r.maxMemory());



        Process p = r.exec("notepad.exe");

        System.out.println("进程是否运行："+p.isAlive());
    }
}
