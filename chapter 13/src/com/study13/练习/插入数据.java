package com.study13.练习;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.impl.C3P0PooledConnection;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * @version : 1.0
 * @auther : 謝     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-09-19:30
 */
public class 插入数据 {
    private String driver;
    private String url;
    private String user;
    private String password;
    public void initparm(String parmfile)throws Exception{
        Properties ppop = new Properties();
        ppop.load(new FileInputStream(parmfile));

        ComboPooledDataSource pool= new ComboPooledDataSource();

        pool.setDriverClass(ppop.getProperty("driver"));
        pool.setJdbcUrl(ppop.getProperty("url"));
        pool.setPassword(ppop.getProperty("password"));
        pool.setMaxStatements(10);
        pool.setInitialPoolSize(10);
        pool.setMinPoolSize(25);
        pool.setMinPoolSize(2);



    }
    public void updateparm(String sql)throws Exception{

    }
}
