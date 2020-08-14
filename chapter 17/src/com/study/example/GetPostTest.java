package com.study.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2019-01-19-16:25
 * @Description :  <br/>
 */
public class GetPostTest {


    /**
     * get请求
     * @param url
     * @param param
     * @return
     */
    public static String sendGet(String url, String param){

        String result = "";
        String urlName = url + "?" + param;
        try {
            URL realUrl = new URL(urlName);

            URLConnection conn = realUrl.openConnection();

            //设置通用属性请求
            conn.setRequestProperty("accept","*/*");
            conn.setRequestProperty("connection","Keep-Alive");
            conn.setRequestProperty("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:64.0) Gecko/20100101 Firefox/64.0");

            //建立实际连接
            conn.connect();
            //获取所有的响应头字段
            Map<String, List<String>> map = conn.getHeaderFields();

            //遍历所有的响应头
            for (String key  : map.keySet()){
                System.out.println(key + "----->"+ map.get(key));
            }
            try (
                //定义bufferReader 输入流来读取URL的响应
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream() , "utf-8"))
            ){
                String line;

                while ((line = in.readLine()) != null){
                    result += "\n" + line;
                }
            }
        }catch (Exception e){
            System.out.println("发送get请求异常");
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 发送post请求
     */
    public static String sendPost(String url,String param){
        String result ="";

        try {
            URL realUrl = new URL(url);

            URLConnection conn = realUrl.openConnection();


            //设置通用属性请求
            conn.setRequestProperty("accept","*/*");
            conn.setRequestProperty("connection","Keep-Alive");
            conn.setRequestProperty("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:64.0) Gecko/20100101 Firefox/64.0");

            //发送post请求必须写这两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            try (
                PrintWriter out = new PrintWriter(conn.getOutputStream())){
                out.println(param);

                out.flush();
            }
            try(
                    //定义输入流读取url的响应
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"))
                    ){
                String line;

                while ((line = in.readLine()) != null){

                    result += "\n" + line;
                }
            }
        }catch (Exception e){
            System.out.println("发送异常");
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {


        String  s = GetPostTest.sendGet("http://www.baidu.com",null);

//        System.out.println(s);
        String a  = "百度云";

        a = URLEncoder.encode(a,"utf-8");
        String s1 = GetPostTest.sendPost("http://www.baidu.com","wd="+a);
        System.out.println(s1);
    }
}
