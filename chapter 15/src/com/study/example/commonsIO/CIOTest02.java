package com.study.example.commonsIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;

import java.io.File;
import java.nio.file.Files;
import java.util.Collection;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: CIOTest02
 * @Create : 2019/12/25
 * @Description :  列出子孙级
 */
public class CIOTest02 {


    public static void main(String[] args) {
        Collection<File> files = FileUtils.listFiles(new File(
                "D:/IdeaProjects/java/chapter 15/src/com/study/example/commonsIO"),
                EmptyFileFilter.NOT_EMPTY,
                DirectoryFileFilter.INSTANCE);

        for (File file : files) {
            System.out.println(file.getAbsoluteFile());
        }


    }



}
