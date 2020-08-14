package com.study.example;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2019-01-19-19:09
 * @Description :  <br/>
 */
public class UdpServer {

    public static final int PORT = 30000;

    //定义每个数据报的大小最小为的4KB
    private static final int DATA_LEN = 4096;

    // 定义接受网络数据的字节数组
    byte[] inBuff = new byte[DATA_LEN];

    //以指定字节数组创建准备接收数据的DataGramPacket对象
    private DatagramPacket inPacket =
            new DatagramPacket(inBuff, inBuff.length);

    //发送的Datagrampacket 对象
    private DatagramPacket outPacket;

    String[] books = new String[]{
            "11111",
            "222222",
            "333333",
            "44444"
    };

    public void init() {
        try (
                //创建 对象
                DatagramSocket socket = new DatagramSocket(PORT)
                ){
            //采用循环接收数据
            for (int i=0;i<1000;i++){
                //读取socket 数据，，放到数组里
                socket.receive(inPacket);

                //判断 inpacket 和inbuff 是否是同一个数组
                System.out.println(inBuff == inPacket.getData());

                System.out.println(new String(inBuff,0,inPacket.getLength()));

                //从数组中取出一个元素作为发送数据
                byte[] sendData = books[i % 4].getBytes();

                outPacket = new DatagramPacket(sendData,
                        sendData.length, inPacket.getSocketAddress());
                socket.send(outPacket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        new UdpServer().init();
    }
}
