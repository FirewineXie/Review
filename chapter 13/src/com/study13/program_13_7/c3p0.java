package com.study13.program_13_7;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-07-21:16
 */
public class c3p0 {
    private String driver;
    private String url;
    private String user;
    private String password;

    public void initparm(String parmfile)throws  Exception{


        Properties ppop = new Properties();
        ppop.load(new FileInputStream(parmfile));

        //创建连接池实例
        ComboPooledDataSource aa = new ComboPooledDataSource();
        //设置连接池连接数据库所需要的驱动
        aa.setDriverClass(ppop.getProperty("driver"));
        //设置连接数据库的URL
        aa.setJdbcUrl(ppop.getProperty("url"));
        //设置连接数据库的密码
        aa.setPassword(ppop.getProperty("pass"));
        //设置连接池的最大连接数
        aa.setMaxPoolSize(40);
        //设置莲池的的最小连接数
        aa.setMinPoolSize(2);
        //设置连接池的初始连接数
        aa.setInitialPoolSize(10);
        //设置连接池的缓存Statement的最大数
        aa.setMaxStatements(180);
        //
    }

}
