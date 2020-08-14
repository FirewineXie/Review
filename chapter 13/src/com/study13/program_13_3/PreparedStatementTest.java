package com.study13.program_13_3;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-07-14:17
 */
public class PreparedStatementTest {
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

    public void insertUseStatement() throws Exception{
        long start = System.currentTimeMillis();
        try(
                //获取数据库连接
                Connection conn = DriverManager.getConnection(url,user,pass);
                //创建Statement对象
                Statement stmt = conn.createStatement()
                ){
            for (int i =0;i<100;i++){
                stmt.executeUpdate("insert into student_table values ("+"null ,'姓名"+i +"', 1)");
            }

            System.out.println("使用Statement费时"+(System.currentTimeMillis() -start));

        }
    }

    public void insertUsePrepare() throws Exception{
        long start = System.currentTimeMillis();
        try(
                Connection conn = DriverManager.getConnection(url,user,pass);
                PreparedStatement pstmt = conn.prepareStatement("insert into student_table values(null,?,1)")){
            for (int i =0;i<100;i++){
                pstmt.setString(1,"姓名"+i);
                pstmt.executeUpdate();
            }
            System.out.println("使用费时："+(System.currentTimeMillis() -start));
        }
    }

    public static void main(String[] args)throws Exception {
        PreparedStatementTest ps = new PreparedStatementTest();
        ps.initParam("H:\\疯狂java讲义\\第十三章_MySQL数据库与JDBC编程\\src\\mysql.ini");
        ps.insertUsePrepare();
        ps.insertUseStatement();
    }
}
