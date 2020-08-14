package com.study.example;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2019-01-19-19:17
 * @Description :  <br/>
 */
public class UdpClient {

    //定义发送数据报的目的地
    public static  final  int DEST_PORT = 30000;
    public  static  final  String DEST_IP = "127.0.0.1";

    //定义每个数据报的大小
    private static final  int DATA_LEN = 4096;

    //接收网络数据的字节数组
    byte[] inBuff  = new byte[DATA_LEN];

    // 指定的字节数组创建准备接受数据的DatagramPacket 对象
    private DatagramPacket inPacket =
            new DatagramPacket(inBuff, inBuff.length);

    //定义一个用于发送的DatagramPacket 对象
    private DatagramPacket outPacket = null;

    public void init (){

        try(
            DatagramSocket socket = new DatagramSocket()
        ){
            outPacket = new DatagramPacket(new byte[0],0, InetAddress.getByName(DEST_IP),DEST_PORT);

            Scanner scan = new Scanner(System.in);

            while (scan.hasNextLine()){
                byte[] buff = scan.nextLine().getBytes();

                outPacket.setData(buff);

                socket.send(outPacket);

                socket.receive(inPacket);

                System.out.println(new String(inBuff ,0,inPacket.getLength()));
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {


        new UdpClient().init();
    }
}
