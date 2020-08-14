package com.study.program;

import java.io.*;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-28-14:14
 */
public class codes_10_2_AutoCloseTest {

    public static void main(String[] args)throws IOException {

//        try(
//            //声明、初始化两个可关闭的资源
//            //try语句会自动关闭两个资源
//            BufferedReader br = new BufferedReader(new FileReader(
//                    "D:\\IdeaProjects\\java\\src\\chapter 10\\src\\com\\study\\program\\codes_10_2_AutoCloseTest.java"));
//            PrintStream ps = new PrintStream(new FileOutputStream("demo.txt"))
//        ){
//            //使用两个资源
//            System.out.println(br.readLine());
//            ps.println("庄生晓梦迷蝴蝶");
//        }
        //改写
       //有final修饰的资源

        final BufferedReader br = new BufferedReader(
                new FileReader("D:\\IdeaProjects\\java\\src\\chapter 10\\src\\com\\study\\program\\codes_10_2_AutoCloseTest.java"));
        // 没有显示使用final修饰，
        PrintStream ps = new PrintStream(new FileOutputStream("demo.txt"));
        //try (br;ps){
        //我用的是java8.所以会有问题
        try{
            System.out.println(br.readLine());
            ps.println("庄生晓梦迷蝴蝶");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
