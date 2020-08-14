package com.demo.practice.sprider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author : Firewine
 * @version : 1.0
 * @Program Name: practice
 * @Create : 2019/12/29
 * @Description :
 * java模拟浏览器
 */
public class Spriderpractice02 {

    public static void main(String[] args) throws IOException {

        //获取URL
        URL url =new URL("https://www.dianping.com");
        //下载资源
        HttpURLConnection  conn =(HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36");
        BufferedReader br =new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        String msg =null;
        while(null!=(msg=br.readLine())) {
            System.out.println(msg);
        }
        br.close();
        //分析
        //处理。。。。
        br.close();

    }
}
