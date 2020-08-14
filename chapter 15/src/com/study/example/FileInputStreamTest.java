package com.study.example;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2019-01-16-14:05
 * @Description :  <br/>
 */
public class FileInputStreamTest {

    public static void main(String[] args) throws IOException {

        //创建字节输入流
        FileInputStream fis = new FileInputStream("FileInputStreamTest.java");

        // 创建一个长度为1024 的竹筒
        byte[] bbuf = new byte[1024];
        //用于保存实际读取的字节数
        int hasRead = 0;

        // 使用循环来重复“取水”过程
        while ((hasRead = fis.read(bbuf)) > 0){
            //取出字节，并且将字节数组转化为字符串输入
            System.out.println(new String(bbuf,0,hasRead));
        }
        //关闭文件输入流，放在finally 快里更加安全
        fis.close();


    }
}
