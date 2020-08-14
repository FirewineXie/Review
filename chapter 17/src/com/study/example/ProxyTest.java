package com.study.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2019-01-19-19:44
 * @Description :  <br/>
 */
public class ProxyTest {

    final String PROXY_ADDR = "IP地址";
    final int PROXY_PORT = 3124;

    //定义想要访问的网站地址
    String urlStr = "http://www.baidu.com";

    public void init() throws IOException {

        URL url = new URL(urlStr);

        Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress(PROXY_ADDR,PROXY_PORT));

        URLConnection connection = url.openConnection(proxy);

        //设置时限
        connection.setConnectTimeout(30000);

        try (
                //通过代理服务器读取数据
                Scanner scanner = new Scanner(connection.getInputStream());
                PrintStream ps = new PrintStream("index.html")
                ){
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);

                ps.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new ProxyTest().init();
    }
}
