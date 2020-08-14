package com.demo.practice;

import com.study.example.InetAddressTest;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author : Firewine
 * @version : 1.0
 * @Program Name: IpTest01
 * @Create : 2019/12/29
 * @Description :
 */
public class IpTest01 {


    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();

        System.out.println(inetAddress.getHostAddress());
        System.out.println(inetAddress.getHostName());


        inetAddress = InetAddress.getByName("www.163.com");
        System.out.println(inetAddress.getHostAddress());
        System.out.println(inetAddress.getHostName());
    }




}
