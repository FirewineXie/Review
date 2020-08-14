package com.study.example;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2019-01-19-14:47
 * @Description :  <br/>
 */
public class URLDecoderTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
//        https://www.baidu.com/baidu?isource=infinity&iname=baidu&itype=web&tn=98012088_9_dg&ch=7&ie=utf-8&wd=%E7%99%BE%E5%BA%A6%E4%BA%91
        // 将application、。。 字符串
        // 转换成字符串
        // 其中的字符串直接从网页复制过来
        String keyword = URLDecoder.decode("%E7%99%BE%E5%BA%A6%E4%BA%91","utf-8");

        System.out.println(keyword);


        String urlstr = URLEncoder.encode("百度云","utf-8");

        System.out.println(urlstr);
    }
}
