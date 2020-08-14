package com.study.example;

import java.io.IOException;
import java.net.InetAddress;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2019-01-19-14:26
 * @Description :  <br/>
 */
public class InetAddressTest {


    public static void main(String[] args) throws IOException {

        //根据主机名来获取对应的InetAddress 实例
        InetAddress ip = InetAddress.getByName("www.baidu.com");

        //判断是否可以到达
        System.out.println("baidu 是否可以到达 ：" + ip.isReachable(2000));

        //获取该InetAddress实例的IP字符串
        System.out.println(ip.getHostAddress());

        // 根据原始IP地址 来获取 对应的InetAddress 实例
        InetAddress local = InetAddress.getByAddress(new byte[]{127,0,0,1});

        System.out.println("本机是否可以到达 ：" + local.isReachable(2000));


        //获取该InetAddress 实例对应的全限定域名
        System.out.println(local.getCanonicalHostName());
    }
}
