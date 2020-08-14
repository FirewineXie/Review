package com.study.example.commonsIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: CIOTest02
 * @Create : 2019/12/25
 * @Description :  列出子孙级
 */
public class CIOTest05 {

    public static void main(String[] args) throws IOException {

        // FileUtils.copyFile(new File("p.png"), new File("p.png"));

        //复制文件到目录
        // FileUtils.copyFileToDirectory(new File(""), new File(""));

        //复制目录到目录
        // FileUtils.copyDirectoryToDirectory();


        //复制目录
        // FileUtils.copyDirectory();


        //拷贝URL内容
        // FileUtils.copyURLToFile();


        String datas = IOUtils.toString(new URL("http://www.baidu.com"), "UTF-8");
        System.out.println(datas);

    }
}
