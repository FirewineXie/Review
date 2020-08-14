package com.study.example.commonsIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @version : 1.0
 * @auther : Firewine
 * @Program Name: CIOTest02
 * @Create : 2019/12/25
 * @Description :  列出子孙级
 */
public class CIOTest04 {

    public static void main(String[] args) throws IOException {


        FileUtils.write(new File("./src/happy.txt"), "学习是一件很伟大的事情",
                "UTF-8", true);

    }
}
