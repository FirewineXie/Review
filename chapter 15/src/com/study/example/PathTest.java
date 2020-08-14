package com.study.example;


import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2019-01-17-16:22
 * @Description :  <br/>
 */
public class PathTest {

    /**
     *  在NIO2 里面 有两个 工具类Files 和Paths
     *  使用Files 工具类 比使用原生的输入输出流更加的方便
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        //以当前路径来创建PAth 对象

        Path path = Paths.get(".");
        System.out.println("path 里包含的路径数量：" + path.getNameCount());

        System.out.println("path 的根路径： "+ path.getRoot());

        //绝对路径

        Path absolutePath = path.toAbsolutePath();

        System.out.println(absolutePath);

        // 获取绝对路径的根路径

        System.out.println("absolutePath 的根路径 ： " + absolutePath.getRoot());

        System.out.println("absolutePath 的路径数量 ： " + absolutePath.getNameCount());

        System.out.println(absolutePath.getName(3));

        //以多个String 来构建 path 对象
        Path path2 = Paths.get("g:","publish","codes");
        System.out.println(path2);
    }
}
