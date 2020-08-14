package com.study.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2019-01-19-14:54
 * @Description :  <br/>
 */
public class DownUtil {

    /**
     *  这个是实现多线程的下载
     *  1. 创建URL对象
     *  2. 获取指定URL 对象的资源大小，
     *  3. 在本地创建一个相同大小文件
     *  4. 计算每个线程需要下载那个部分
     *  5. 一次创建、启动线程来下载
     */
    /**
     * 如果要实现断点下载，必须再新建一个文件，(配置文件) 分别记录 每个线程已经下载到那个字节，当网络断开后再次开始下载，每个线程根据配置
     * 文件里记录的位置向后下载
     */
    //定义下载资源的路径

    private String path;

    //指定所下载的文件的保存位置

    private String targetFile;

    //定义需要使用多少个线程下载资源

    private int threadNum;

    //定义下载的线程对象

    private DownThread[] threads;

    //定义下载的文件的总大小

    private int fileSize;

    public DownUtil(String path, String targetFile, int threadNum) {
        this.path = path;
        this.targetFile = targetFile;
        this.threadNum = threadNum;
        threads = new DownThread[threadNum];
    }

    public void download() throws IOException {
        URL url = new URL(path);

        HttpURLConnection conn  = (HttpURLConnection) url.openConnection();

        conn.setConnectTimeout(5 * 1000);
        conn.setRequestMethod("GET");

        conn.setRequestProperty(
                "Accept",
                "image/gif ,image/jpeg , image/pjeg , image/pjpeg,"+
                        "application/x-shockwave-flash,application/xaml+xml,"+
                        "application/vnd.ms-xpsdocument,application/x-ms-xbap,"+
                        "application/x-ms-application,application/vnd.ms-excel,"+
                        "application/vnd.ms-powerpoint,application/nsword,*/*"
        );
        conn.setRequestProperty("Accept-Language","zh-CN");
        conn.setRequestProperty("Charset","UTF-8");
        conn.setRequestProperty("Connection","Keep-Alive");

        //得到文件大小
        fileSize = conn.getContentLength();
        conn.disconnect();
        int currentPartSize = fileSize / threadNum + 1;
        RandomAccessFile file = new RandomAccessFile(targetFile, "rw");

        //设置本地文件大小
        file.setLength(fileSize);
        file.close();
        for (int i =0; i< threadNum; i++){

            //计算每个线程下载的开始位置
            int startPos = i * currentPartSize ;
            //每个线程使用一个RandomAccessFile 进行下载
            RandomAccessFile currentPart = new RandomAccessFile(targetFile , "rw");

            currentPart.seek(startPos);
            threads[i] = new DownThread(startPos,currentPartSize,currentPart);

            threads[i].start();
        }
    }
    public double getCompleteRate(){

        //统计多线程已经下载的总大小
        int sumSize = 0;
        for (int i=0; i < threadNum ; i++){
            sumSize += threads[i].length;
        }
        return sumSize * 1.0 / fileSize;
    }
    private class DownThread extends Thread{

        //当前线程的下载位置

        private int startPos;

        //定义当前线程需要下载的文件大小

        private int currentPartSize;

        //当前线程需要下载的文件快

        private RandomAccessFile currentPart;

        public int length;


        public DownThread(int startPos, int currentPartSize, RandomAccessFile currentPart) {

            this.startPos = startPos;
            this.currentPartSize = currentPartSize;
            this.currentPart = currentPart;

        }

        @Override
        public void run() {

            try {
                URL url = new URL(path);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setConnectTimeout(5 * 1000);
                connection.setRequestMethod("GET");
                connection.setRequestProperty(
                        "Accept",
                        "image/gif ,image/jpeg , image/pjeg , image/pjpeg,"+
                                "application/x-shockwave-flash,application/xaml+xml,"+
                                "application/vnd.ms-xpsdocument,application/x-ms-xbap,"+
                                "application/x-ms-application,application/vnd.ms-excel,"+
                                "application/vnd.ms-powerpoint,application/nsword,*/*"
                );
                connection.setRequestProperty("Accept-Language","zh-CN");
                connection.setRequestProperty("Charset","UTF-8");
                InputStream inputStream = connection.getInputStream();

                inputStream.skip(this.startPos);
                byte[] buffer = new byte[1024];

                int hasRead = 0;

                while ((length < currentPartSize)&& (hasRead = inputStream.read(buffer)) != -1){
                    currentPart.write(buffer,0,hasRead);
                }
                currentPart.close();
                inputStream.close();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
