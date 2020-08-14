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
 * @Create : 2018-09-06-20:11
 */
public class ExecuteDml {
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
    }

    public int insertData(String sql) throws  Exception{
        //加载驱动
        Class.forName(driver);
        try(
                Connection conn = DriverManager.getConnection(url,user,pass);
                Statement stmt = conn.createStatement()){
            return stmt.executeUpdate(sql);
        }
    }

    public static void main(String[] args)throws Exception {

        ExecuteDml ed = new ExecuteDml();
        ed.initParam("H:\\疯狂java讲义\\第十三章_MySQL数据库与JDBC编程\\src\\mysql.ini");
        int result = ed.insertData("insert into jdbc_test(jdbc_name,jdbc_desc)"
            +"select s.student_name,t.teacher_name"
            +"from student_table s,teacher_table t"
            +"where s.java_teacher = t.teacher_id;");
        System.out.println("一共有多少个记录受影响"+result);
    }

}
