package com.study.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2019-01-16-15:50
 * @Description :  <br/>
 */
public class KeyinTest {

    /**
     * 体系 中该提供了两个转换流，用于实现将字节流 转换成字符流 其中InputStreamReader 和OutputStreamReader
     *
     */
    /**
     * 跟上面的输入输出都是处理流，通过各种进行包装，更好的去解析
     * @param args
     */
    public static void main(String[] args) {

        try (
                //将System。in 对象转换成Reader对象
                InputStreamReader reader = new InputStreamReader(System.in);
                //将普通的Reader 包装成BufferedReader

                BufferedReader br = new BufferedReader(reader)
        )
        {
            String line = null;
            //采用 循环方式来逐行的读取
            while ((line = br.readLine()) != null){
                //如果读到 字符串为exit 则程序退出
                if (line.equals("exit")){
                    System.exit(1);
                }
                //打印内容
                System.out.println("输入内容 ： " + line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
