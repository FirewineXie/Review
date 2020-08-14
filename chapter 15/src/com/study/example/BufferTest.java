package com.study.example;

import java.nio.CharBuffer;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2019-01-17-15:17
 * @Description :  <br/>
 */
public class BufferTest {

    /**
     * 新IO 将文件 或文件 的一段区域映射到内存中，这样就可以像访问内存一样来访问文件了，
     * 重要的分文两个 一个是Channel 和Buffer 的两个核心对象，
     * 而Channel 对于传统的最大的却别是 有一个map 方法， 可以将 一块数据 映射到文件中
     *
     * buffer 可以被理解是一个容器， 但是本质是一个数组，
     * @param args
     */
    public static void main(String[] args) {


        //创建Buffer
        CharBuffer buff = CharBuffer.allocate(8);
        System.out.println("capacity : " + buff.capacity());
        System.out.println("limit ； "+ buff.limit());
        System.out.println("position : " + buff.position());

        //放入元素
        buff.put('a');
        buff.put('b');
        buff.put('c');
        System.out.println("加入三个元素 后 ， position = " + buff.position());

        //调用 flip 方法
        buff.flip();
        System.out.println("执行filp 后， limit = "+ buff.limit());
        System.out.println("position :" + buff.position());

        //取出第一个元素
        System.out.println("第一个元素 ： " + buff.get());
        System.out.println("取出一个元素后 ：" + buff.position());

        //调用clear 方法
        buff.clear();

        System.out.println("执行之后 limit ：" + buff.limit() );
        System.out.println("执行之后 position ： " + buff.position());


        /**
         * Buffer 中有三个重要的概念， 容量，界限，位置
         * 容量 ： 缓冲区的容量
         * 界限 ： 第一个不应该被读出或者写入的缓冲区位置索引
         * 位置 ： 用于指明下一个可以被读出的或者写入的缓冲区位置索引
         *
         *
         * Buffer 有两个重要的方法 ： flip 和clear   flip 为从Buffer 中取出数据做好准备=
         * clear 是 为再次向buffer 中装入 数据做好准备
         *
         * Buffer 既支持对单个数据的访问，也支持对批量数据的访问 （数组为基础）
         *
         */
        /**
         * Channel 是建立在Buffer上的，
         * 当进行数据的访问的时候， 必须要在Buffer 有数据才能够传向Channel
         */
    }
}
