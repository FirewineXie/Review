package com.study.program;

import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-02-20:15
 */
public class codes_18_2_URLClassLoaderTest {

    private static Connection connection;
    //定义一个获取数据库连接的方法

    public static Connection getConnection(String url,String user,String pass)throws Exception{

        if (connection == null){
            //创建一个URL数组
            URL[] urls = {new URL("file:G:\\Program Files\\mysql-connect\\mysql-connector-java-5.1.46.jar")};

            //以默认的ClassLoader作为父ClassLoader 创建URLClassLoader
            URLClassLoader myClassLoader = new URLClassLoader(urls);
            //可以从网络上和ftp还有本地都是可以进行获取url的
            //加载mysql 的jdbc驱动 ，并创建实例
            Driver driver = (Driver)myClassLoader.loadClass("com.mysql.jdbc.Driver").getConstructor().newInstance();

            //创建一个设置JDBC连接属性的properties 对象
            Properties properties = new Properties();

            properties.getProperty("user",user);
            properties.getProperty("password",pass);

            connection = driver.connect(url,properties);
        }
        return connection;
    }

    public static void main(String[] args)throws Exception {
        System.out.println(getConnection("jdbc:mysql://localhost:3306/runoob","root","123456"));
    }
}
