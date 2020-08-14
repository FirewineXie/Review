package com.study.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2019-01-16-20:51
 * @Description :  <br/>
 */
public class Redirect {

    public  void Out(){
        try(
                //一次性创建 PrintStream 输出流
                PrintStream ps = new PrintStream(new FileOutputStream("out.txt"))
                )
        {
            //将标准输出重定向到ps输出流
            System.setOut(ps);
            //向标准输出输出一个字符串
            System.out.println("这是一个普通字符串");
            //向标准输出输出一个对象
            System.out.println(new Redirect());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public  void In(){
        try ( FileInputStream fis = new FileInputStream("Redirect.java")){

            //将标准输入重定向到Fis 输入流
            System.setIn(fis);

            Scanner sc = new Scanner(System.in);

            //增加分隔符
            sc.useDelimiter("\n");

            while (sc.hasNext()){
                System.out.println("键盘输入的内容是 ：" + sc.next());
            }

        }catch (IOException e){
            e.printStackTrace();
        }



    }

}

