package com.study.example;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2019-01-16-14:40
 * @Description :  <br/>
 */
public class PrintStreamTest {

    /**
     * 对于处理流的使用也是非常的简单，通常只是需要在创建处理流时传入一个节点流作为构造器参数即可，这样创建的
     * 的处理流就是 包装了该节点流的处理流
     * @param args
     */
    public static void main(String[] args) {

        try (
            FileOutputStream fos = new FileOutputStream("test.txt");
            PrintStream ps = new PrintStream(fos))
        {

                //使用 PrintStream 执行输出
                ps.println("普通字符串");

                // 直接使用printStream 输出对象
                ps.println(new PrintStreamTest());
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
