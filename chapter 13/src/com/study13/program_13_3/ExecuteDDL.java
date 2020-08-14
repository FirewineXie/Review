package com.study13.program_13_3;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-06-19:36
 */
public class ExecuteDDL {
    private String driver;
    private String url;
    private String user;
    private String pass;

    public void initParam(String paramFile)throws Exception{
        //使用Properties 类来加载属性文件
        Properties props = new Properties();
        props.load(new FileInputStream(paramFile));
        driver = props.getProperty("driver");
        url = props.getProperty("url");
        user = props.getProperty("user");
        pass = props.getProperty("pass");
        Class.forName(driver);
    }
    public void createTable(String sql) throws  Exception{
        //加载驱动

        try(
                //获取数据库连接
                Connection conn = DriverManager.getConnection(url,user,pass);
                //使用Connection 创建一个Statement对象
                Statement stmt = conn.createStatement()){
            //执行DDL语句，创建数据库
            stmt.executeUpdate(sql);
        }
    }

    public static void main(String[] args)throws Exception {

        ExecuteDDL ed = new ExecuteDDL();
        ed.initParam("mysql.ini");
        ed.createTable("create table jdbc_test"+"( jdbc_id int auto_increment primary key,"
        +"jdbc_name varchar(255),"+"jdbc_desc text);");
        System.out.println("建表成功");


    }
}
