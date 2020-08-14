package com.study.program_8;

import java.io.FileOutputStream;
import java.util.Properties;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-23-11:46
 */
public class codes_8_6_Properties {

    public static void main(String[] args) throws Exception{

        Properties prop = new Properties();

        prop.setProperty("username","yeeku");

        prop.setProperty("passeord","kuuu");

        prop.store(new FileOutputStream("a.ini"),"comment line");


    }
}
