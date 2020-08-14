package com.study.example;

import java.io.FileNotFoundException;
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
 * @Create : 2019-01-16-21:03
 * @Description :  <br/>
 */
public class WriteToProcess {

    /**
     * 该程序 实现了 java程序 中启动 java虚拟机 运行另一个java程序 ，并向另一个 java程序 中输入数据
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        //运行 java ReadStandard命令 ，返回运行 该命令的子进程
        Process p = Runtime.getRuntime().exec("java ReadStandard");
        try (
                // 以p 进程的输出流创建PrintStream 对象
                // 这个输出流对本程序是输出流， 对p进程 则是输入流
                PrintStream ps = new PrintStream(p.getOutputStream())){


            //向ReadStandard 程序写入内容，然后被读取
            ps.println("普通字符串");
            ps.println(new WriteToProcess());

        }
    }
}

// 定义一个ReadStandard 类，该类可以接收标准输入
// 并将标准输入写入out..txt文件
class ReadStandard{

    public static void main(String[] args) {

        try (
            //使用 System。 in创建 Scanner 对象， 用于获取标准输入
            Scanner sc = new Scanner(System.in);
            PrintStream ps = new PrintStream(
                    new FileOutputStream("out.txt")
            ))
            {
                sc.useDelimiter("\n");
                //判断是否还有下一个输入项
                while(sc.hasNext()){
                    ps.println("键盘输入的内容是 ： " + sc.next());
            }
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
