package com.demo.practice;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @version : 1.0
 * @author Firewine
 * @Program Name: WebDownloader
 * @Create : 2019/12/27
 * @Description :
 */
public class WebDownloader {

    private String  url;


    private  String name;
    //名字

    /**
     * 下载
     * @param url
     * @param name
     */
    public void download(String url, String name)  {
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }catch (MalformedURLException e)  {
            e.printStackTrace();
            System.out.println("不合法的URl");
        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("下载失败");
        }
    }


}
