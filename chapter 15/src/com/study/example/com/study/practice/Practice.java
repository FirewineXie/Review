package com.study.example.com.study.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2019-01-17-16:54
 * @Description :  <br/>
 */
public class Practice {

    /**
     * 用户输入一个路径 ，该工具类会将该路径下(子目录) 的所有文件显示出来
     */


    public static void main(String[] args) throws IOException {

//        Scanner in  = new Scanner(System.in);
        String in = "D:\\document\\";
        File file = new File(in.toString());

        T3 bb = new T3();

        bb.toatal("d:\\document\\", "d:\\hyu\\");
        if (file.exists()) {

        } else {
            System.out.println("输入路径错误 或者 该路径不存在");
        }


    }
}

class T1 {

    public void ergioc(String path) throws IOException {
        Files.walkFileTree(Paths.get(path), new SimpleFileVisitor<Path>() {


            //访问目录
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("正在访问 " + dir + "目录");


                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return super.visitFileFailed(file, exc);
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                //当访问到目录之后，出发的方法
                return super.postVisitDirectory(dir, exc);
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

                System.out.println("正在访问的文件 ： " + file + "文件");

                return FileVisitResult.CONTINUE;
            }
        });

    }
}

class T2 {

    int dirCount = 0;
    int fileCount = 0;

    public void Count1(String path) {
        File file = new File(path);
        File[] listFile = file.listFiles();

        for (int i = 0; i < listFile.length; i++) {

            if (listFile[i].isDirectory()) {
                dirCount++;
                Count1(listFile[i].toString());
            } else if (listFile[i].isFile()) {
                fileCount++;

            } else {
                Count1(listFile[i].toString());
            }
        }
    }

    public void sc() {
        System.out.println("文件数 ：" + fileCount);
        System.out.println("目录数 ： " + dirCount);
    }

}

class T3 {


    //写一个总的方法来引用这个方法，，然后进行
    public void toatal(String path, String path1) {

        File file1 = new File(path);
        File file2 = new File(path1);

        if (!file2.exists()) {
            System.out.println("暂时没有写 合并，，该文件或文件夹已经存在");
        } else {
            CountCatalog(path, path1);
            copyFile(path, path1);
        }

    }

    /**
     * 如何通过java实现一个cpoy 功能 ； 如果是目录则递归进行复制，如果是文件，则直接复制
     * 1. 首先 得到想要复制的文件或文件目录，
     * 2. 如果是文件目录得到目录里面是否有 目录或者是文件
     * <p>
     * 首先输入的路径是 第一个是被复制的文件或者文件夹  第二是 目的路径地址
     */
    public void copyFile(String path, String path1) {
        File file = new File(path);
        File file1 = new File(path1);
        File[] listFile = file.listFiles();


        //如果不行，就用三个方法来合成起来
        for (int i = 0; i < listFile.length; i++) {

            if (listFile[i].isDirectory()) {

                copyFile(listFile[i].toString(), file1.getPath().toString());
            } else if (listFile[i].isFile()) {


                String la = listFile[i].toString().substring(11, listFile[i].toString().length());
                String tmp = file1.toString() + la;

                File tmp1 = new File(tmp);
                try {
                    if (tmp1.createNewFile()) {

                        FileInputStream fileInputStream = new FileInputStream(listFile[i].toString());
                        FileOutputStream fileOutputStream = new FileOutputStream(tmp);

                        int hasRead = 0;
                        byte[] bbuf = new byte[1024];
                        while ((hasRead = fileInputStream.read(bbuf)) > 0) {
                            fileOutputStream.write(bbuf);
                        }
                        System.out.println(tmp + "      创建成功");
                        fileInputStream.close();
                        fileOutputStream.close();
                    } else {
                        System.out.println("文件已经存在");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {

                }

                // 将父目录代替
                String mulu1 = listFile[i].toString().replace(la, file1.toString());


            } else {
                copyFile(listFile[i].toString(), file1.getPath().toString());
            }
        }
    }

    /**
     * 1. http://s1.ananas.chaoxing.com/video/1b/3c/ce/06f86c22f1fa331d677cae182d9aa29c/hd.mp4?at_=1547780132903&ak_=92b97d5313d3fc71c58cc011fcbc9857&ad_=be8f7b0f274dff6c747bffeb5ac98720
     * 2.http://s1.ananas.chaoxing.com/video/9c/8e/28/54213c7e0ba8bc0b7e91fcb88d821a57/hd.mp4?at_=1547777502767&ak_=c2adcefcff9f433d197d6a7f0e856dc3&ad_=52eaeef152d47e6636a4dde06d553d74
     */
    /**
     * 我觉得应该使用递归 是更加的方便的，
     * 1. 首先， 你复制的文件或者目录是不一样的，如果是文件 那么 路径就是代表的文件
     * 2. 如果是目录， 但是你复制的目录的父目录 然后的子目录，所以你先要创建父目录
     * 3. 或者不是使用递归，而是使用树图或者说是回溯法，是不更加的方便 ？？？？？？？？？？？？？？？
     *
     * @param path
     */
    public void CountCatalog(String path, String path1) {
        File file = new File(path);
        File file1 = new File(path1);
        File[] listFile = file.listFiles();

        // 首先是不该判断是否是这个 目录是否在这个地方是否存在，如果存在，现在现在先不写合并
        // 如果没有 首先你要创建父目录
        // 然后通过递归得到下面的目录和文件
        // 但是 目录会自动根据文件的绝对路径进行创建的，所以的，使用mkdirs 可以直接并且非常的方便
        /**
         * 现在的难点就是 ： 前面获取的路径 可是并不能使用啊
         *
         * 我可以 通过字符串的形式， 去确定修改绝对路径不就行了吗
         */


        for (int i = 0; i < listFile.length; i++) {

            if (listFile[i].isDirectory()) {

                // 父目录
                //父目录不可变所以提到for语句上面
                String la = listFile[i].getParent();

                // 将父目录代替
                String mulu1 = listFile[i].toString().replace(la, file1.toString());
                File tmp = new File(mulu1);

                // 创建目录
                if (tmp.mkdirs()) {
                    System.out.println(mulu1 + "      创建成功");
                }
                {
                    System.out.println("文件夹已经存在");
                }
                //第二个参数，，只是在每个递归中保存这个路径
                CountCatalog(listFile[i].toString(), mulu1);

            } else if (listFile[i].isFile()) {

            } else {
                CountCatalog(listFile[i].toString(), file1.getPath().toString());
            }
        }
    }


}
