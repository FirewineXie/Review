package com.java.logic.note;

import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: Demo .java
 * @Create : 2019-04-30-10:04
 * @Description :
 */
public class Demo {

    public static void recover(String str) throws UnsupportedEncodingException {
        String[] charsets = new String[]{"windows-1252", "GB18030","UTF-8"};
        for (int i=0;i < charsets.length ;i++){
            for (int j=0; j< charsets.length;j++){
                if (i!=j){
                    String s = new String(str.getBytes(charsets[i]),charsets[j]);
                    System.out.println("原来编码假设是 ： "+charsets[j] + "    "
                    + "转换后的编码 "+ charsets[i]);

                    System.out.println(s);
                    System.out.println();

                }
            }
        }
    }

    public static void main(String[] args) throws UnsupportedEncodingException {

        recover("1233");
    }



}
class T2 {

    int dirCount = 0;
    int fileCount = 0;

    public void Count1(String path) {
        File file = new File(path);
        File[] listFile = file.listFiles();

        for (int i = 0; i < listFile.length; i++) {

            if (listFile[i].isDirectory()) {
                dirCount++;
                Count1(listFile[i].toString());
            } else if (listFile[i].isFile()) {
                fileCount++;

            } else {
                Count1(listFile[i].toString());
            }
        }
    }

    public void sc() {
        System.out.println("文件数 ：" + fileCount);
        System.out.println("目录数 ： " + dirCount);
    }

}