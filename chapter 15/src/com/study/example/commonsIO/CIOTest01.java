package com.study.example.commonsIO;

import org.apache.commons.io.FileUtils;

import java.io.File;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: CIOTest01
 * @Create : 2019/12/25
 * @Description :
 */
public class CIOTest01 {


    public static void main(String[] args) {
        //文件大小
        long len = FileUtils.sizeOf(new File("D:/IdeaProjects/java/chapter 15/src/com/study/example/commonsIO/CIOTest01.java"));
        //目录大小
        len = FileUtils.sizeOf(new File("D:/IdeaProjects/java/chapter 15/src/com/study/example/commonsIO"));


        System.out.println(len);
        

    }
}
