package com.study13.program_13_7;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-07-20:55
 */
public class BatchTest {
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
        Class.forName(driver);
    }

    public void insertBatch(String[] sqls) throws  Exception{
        try(
                Connection conn = DriverManager.getConnection(url);

                ){
            //关闭自动提交开启事务，
            conn.setAutoCommit(false);

            //保存当前的自动提交事务
            boolean autoCommit = conn.getAutoCommit();
            //关闭自动提交
            conn.setAutoCommit(false);
            try(
                    Statement stmt = conn.createStatement();
                    ){
                for (String sql : sqls){
                    stmt.addBatch(sql);
                }

                stmt.executeLargeBatch();

                //
                conn.commit();
                //恢复原有的自动提交模式
                conn.setAutoCommit(autoCommit);
            }
            conn.commit();
        }
    }

    public static void main(String[] args)throws Exception {
        TransactionTest tt = new TransactionTest();
        tt.initParm("H:\\疯狂java讲义\\第十三章_MySQL数据库与JDBC编程\\src\\mysql.ini");

        String[] sqls = new String[]{
                "insert into student_table values(null , 'aaa' , 1)",
                "insert into student_table values(null , 'vvv' , 1)",
                "insert into student_table values(null , 'ccc' , 1)",
                //这个语句会犯错违反外键约束
                "insert into student_table values(null , 'ccc' , 5)"
        };

        tt.insertInTransaction(sqls);
    }
}
