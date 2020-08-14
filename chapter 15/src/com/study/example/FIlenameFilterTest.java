package com.study.example;

import java.io.File;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2019-01-16-11:54
 * @Description :  <br/>
 */
public class FIlenameFilterTest {

    /**
     *  accept 就是指定自己的规则，指定那些文件 应该有list 方法列出
     *
     * @param args
     */
    public static void main(String[] args) {

        File file = new File(".");
        // 使用lambda 表达式 (目标类型为FIlenameFilter ) 实现文件过滤器
        // 如果文件名 .java 结尾 ，或者 文件对应一个路径，则返回true
        String[] nameList = file.list(
                ((dir, name) -> name.endsWith(".java") || new File(name).isDirectory())

        );
        for(String name : nameList){
            System.out.println(name);
        }
    }
}
