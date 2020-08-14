package com.demo.practice.udp;



import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author : Firewine
 * @version : 1.0
 * @Program Name: UdpServer
 * @Create : 2019/12/29
 * @Description :
 * 基本流程: 接收端
 * Address already in use: Cannot bind  同一个协议下端口不允许冲突
 * 1、使用DatagramSocket  指定端口 创建接收端
 * 2、准备容器 封装成DatagramPacket 包裹
 * 3、阻塞式接收包裹receive​(DatagramPacket p)
 * 4、分析数据
 *    byte[]  getData​()
 *                getLength​()
 * 5、释放资源
 */
public class UdpServer {

    public static void main(String[] args) throws IOException {
        System.out.println("接收中。。。。");
        DatagramSocket server = new DatagramSocket(9999);


        byte[] container = new byte[1024 * 60];
        DatagramPacket packet = new DatagramPacket(container, 0, container.length);

        //阻塞式
        server.receive(packet);


        byte[] datas = packet.getData();
        int len = packet.getLength();

        System.out.println(new java.lang.String(datas,0,len));


        server.close();
    }


}
