package com.study13.program_13_3;

import java.sql.*;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-06-18:14
 */
public class ConnMysql {

    public static void main(String[] args) throws Exception{

        //1.加载驱动，使用反射的知识，，可以后面会认真的学习
        Class.forName("com.mysql.jdbc.Driver");
        try{
            //2.使用DriverManager 获取数据库连接
            //其中返回的Connection 就代表java程序和数据库的连接
            //不同数据库的URL写法需要查驱动文档，用户名，密码有DBA分配
            Connection conn = DriverManager.getConnection(
                    "Jdbc:mysql//localhost:3306/spring4?:useSSL=true","root","123456"
            );
            //3.使用Connection 来创建一个Statement对象
            Statement stmt = conn.createStatement();
            //4.执行sql语句
            /*
                Statement 有三种可以执行Sql语句的方法：
                    1.execute 可执行任何Sql语句-返回一个boolean值
                        如果执行后第一个结果是ResultSet，则返回true
                    2. executeQuery 执行select语句 - 返回查询到的结果集
                    3. executeUpdate 用于执行DML语句--返回一个整数
                        代表被sql语句影响的记录条数
             */
            ResultSet rs = stmt.executeQuery("select *, teacher_name"+"from department");
            {
                //ResultSet 有一系列的GetXxx索引|列名的方法用于获取记录的指针，
                //指向行、特定的列的值，不断的使用next将记录指针下移一行
                //如果移动之后，记录指针依旧指向有效行，则next方法返回true
                while (rs.next()){
                    System.out.println(rs.getInt(1) + "\t"
                    +rs.getString(2) + "\t");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
