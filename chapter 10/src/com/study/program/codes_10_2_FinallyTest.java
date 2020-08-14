package com.study.program;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-27-15:42
 */
public class codes_10_2_FinallyTest {

    public static void main(String[] args) {

        FileInputStream fis = null;

        try{
            fis = new FileInputStream("a.txt");
        }catch (IOException ice){
            System.out.println(ice.getMessage());

            //return强制方法返回
            return;
            //使用exit退出虚拟机
            //System.exit(1);
        }finally {
            if (fis != null){
                try{
                    fis.close();
                }catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
            System.out.println("执行finally 的资源回收");
        }
    }
}
