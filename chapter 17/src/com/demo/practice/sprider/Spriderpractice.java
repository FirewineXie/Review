package com.demo.practice.sprider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author : Firewine
 * @version : 1.0
 * @Program Name: practice
 * @Create : 2019/12/29
 * @Description :
 */
public class Spriderpractice {

    public static void main(String[] args) throws IOException {

        URL url = new URL("http://www.jd.com");

        InputStream is = url.openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        String msg = null;
        while (null != (msg = br.readLine())) {
            System.out.println(msg);
        }
        br.close();

    }
}
