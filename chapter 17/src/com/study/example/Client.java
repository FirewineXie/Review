package com.study.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2019-01-19-16:58
 * @Description :  <br/>
 */
public class Client {


    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1",30000);
        BufferedReader br = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        String line = br.readLine();

        System.out.println("来自服务器 的数据 "+ line);

        br.close();
        socket.close();

    }
}
