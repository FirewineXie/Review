package com.study.example;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2019-01-19-19:51
 * @Description :  <br/>
 */
public class PeoxySelectorTest {


    final String PROXY_ADDR = "IP地址";
    final int PROXY_PORT = 3124;

    //定义想要访问的网站地址
    String urlStr = "http://www.baidu.com";

    public void init() throws IOException {

        //注册默认的代理选择器
        ProxySelector.setDefault(new ProxySelector() {
            @Override
            public List<Proxy> select(URI uri) {
                //本程序总是返回特定的代理服务器
                List<Proxy> result = new ArrayList<>();

                result.add(new Proxy(Proxy.Type.HTTP,new InetSocketAddress(PROXY_ADDR,PROXY_PORT)));
                return result;
            }

            @Override
            public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
                System.out.println("无法连接服务器");

            }
        });

        URL url = new URL(urlStr);

        URLConnection connection = url.openConnection();
    }

}
