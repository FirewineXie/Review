package com.study.example.commonsIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: CIOTest02
 * @Create : 2019/12/25
 * @Description :  列出子孙级
 */
public class CIOTest03 {

    public static void main(String[] args) throws IOException {
        String msg = FileUtils.readFileToString(new File("src/第15章_输入输出.md"), "UTF-8");
        System.out.println(msg);

        byte[] datas = FileUtils.readFileToByteArray(new File("src/第15章_输入输出.md"));
        System.out.println(datas.length);



        //逐行读取
        List<String> msgs = FileUtils.readLines(new File("src/第15章_输入输出.md"));

        for (String string : msgs) {
            System.out.println(string);

        }

        //迭代器
        LineIterator it = FileUtils.lineIterator(new File("src/第15章_输入输出.md"));
        while (it.hasNext()) {
            System.out.println(it.nextLine());
        }
    }
}
