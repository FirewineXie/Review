package com.study.example;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2019-01-16-21:27
 * @Description :  <br/>
 */
public class InsertContent {

    public static void  insert (String fileName, long  pos, String insertContent) throws IOException {

        File tmp = File.createTempFile("tmp",null);

        tmp.deleteOnExit();
        try (
            RandomAccessFile raf = new RandomAccessFile(fileName , "rw");
            //使用临时文件来保存插入点后的数据
            FileOutputStream tmpOut = new FileOutputStream(tmp);
            FileInputStream tmpIn = new FileInputStream(tmp)){

            raf.seek(pos);
            // -----下面代码 将插入点后的内容读入临时文件中保存
            byte[] bbuf = new byte[64];
            //用于保存 实际读取的字节数
            int hasRead = 0;
            while ((hasRead =raf.read(bbuf)) > 0){
                tmpOut.write(bbuf,0,hasRead);
            }
            //----下面代码实际插入内容
            raf.seek(pos);

            // 追加需要插入的内容
            raf.write(insertContent.getBytes());

            while ((hasRead = tmpIn.read(bbuf)) > 0){
                raf.write(bbuf,0,hasRead);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        insert("InsertContent.java",45,"插入的内容\r\n");
    }
}
