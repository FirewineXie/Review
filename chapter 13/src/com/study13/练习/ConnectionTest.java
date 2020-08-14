package com.study13.练习;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Date;
import java.util.Properties;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-07-16:22
 */
public class ConnectionTest {
    private String driver;
    private String user;
    private String password;
    private String url;

    private void initParm(String parmer)throws Exception{
        Properties ppop = new Properties();

        ppop.load(new FileInputStream(parmer));

        driver = ppop.getProperty("driver");
        url =ppop.getProperty("url");
        password = ppop.getProperty("password");
        user = ppop.getProperty("user");


        //加载驱动

    }
    private int insertData(String sql)throws Exception{
        try (
                Connection conn  = DriverManager.getConnection(url,user,password);
                Statement stmt =conn.createStatement();
                ){
            return stmt.executeUpdate(sql);
            //返回受影响的记录条数
        }
    }




    public static void main(String[] args)throws Exception {


        ConnectionTest n = new ConnectionTest();
        n.initParm("H:\\疯狂java讲义\\第十三章_MySQL数据库与JDBC编程\\src\\com\\study13\\练习\\school.ini");


//
//        Class.forName("com.mysql.jdbc.Driver");
//
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=true",
//                "root","123456");
//
//        Statement stmt  = conn.createStatement();
//
//        ResultSet rs = stmt.executeQuery("show tables;");
//        stmt.executeUpdate("create table jdbc_test1 "
//                            + "( jdbc_id int auto_increment primary key,"
//                            + "jdbc_name varchar(255),"
//                            + "jdbc_desc text);");
        //现在只是查询数据库，，
        //现在要把ResultSet的数据打印到控制台中
//        while (rs.next()){
////            System.out.println(rs.getMetaData());//打印对象列的属性和方法
//            System.out.println(rs.getRow());
//            System.out.println(rs.getString(1));
//        }
//
//        stmt.close();
//        conn.close();
//
        /**
         * 上面在实战的方面是通过方法进行分装的
         * 尤其是配置 文件
         */

    }
}
