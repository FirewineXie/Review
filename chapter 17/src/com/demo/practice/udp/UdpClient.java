package com.demo.practice.udp;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * @author : Firewine
 * @version : 1.0
 * @Program Name: UdpClient
 * @Create : 2019/12/29
 * @Description :
 * 基本流程: 发送端
 * 1、使用DatagramSocket  指定端口 创建发送端
 * 2、准备数据 一定转成字节数组
 * 3、 封装成DatagramPacket 包裹，需要指定目的地
 * 4、发送包裹send​(DatagramPacket p) *
 * 5、释放资源
 */
public class UdpClient {

    public static void main(String[] args) throws IOException {
        System.out.println("发送启动中");
        DatagramSocket client = new DatagramSocket(8888);

        String data = "测试";
        byte[] datas = data.getBytes();


        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));
        client.send(packet);
        client.close();
    }



}
