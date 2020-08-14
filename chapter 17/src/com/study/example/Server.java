package com.study.example;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2019-01-19-16:52
 * @Description :  <br/>
 */
public class Server {
    /**
     * 基于TCP/IP协议的网络编程
     *
     *
     * 1. TCP 服务器端  使用的是 ServerSocket 创建服务器端
     * 2. 客户端通常使用Socket 的构造器  进行通信 有两个构造器 ，一个是默认的IP ，一个是可选择IP的
     *
     */
    public static void main(String[] args) throws IOException {

        //创建一个ServerSocket 用于监听客户端的连接请求
        ServerSocket ss = new ServerSocket(30000);
        while (true){
            Socket s = ss.accept();

            PrintStream ps = new PrintStream(s.getOutputStream());

            //进行普通的IO操作
            ps.println("nihao ");

            ps.close();
            s.close();
        }
    }
}
