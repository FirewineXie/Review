package com.study.example.com.study.practice;

import java.io.*;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: IOTest02
 * @Create : 2019/12/25
 * @Description :
 */
public class IOTest02 {


    public static void main(String[] args) {
        //1. 创建源
        File src = new File("test.txt");
        //2. 选择流
        try{
            InputStream is = new FileInputStream(src);
            //3. 读取
            int data1 = is.read();
            int data2  = is .read();
            int data3 = is.read();
            System.out.println(data1 + data2 + data3);

            //释放资源
            is.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
