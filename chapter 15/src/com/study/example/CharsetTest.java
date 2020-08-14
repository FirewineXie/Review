package com.study.example;

import java.nio.charset.Charset;
import java.util.SortedMap;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2019-01-17-15:44
 * @Description :  <br/>
 */
public class CharsetTest {

    public static void main(String[] args) {
        //获取java支持的全部字符集

        SortedMap<String, Charset> map = Charset.availableCharsets();

        for(String alias :map.keySet()){
            //输出字符集的别名 和对应的Charset 对象
            System.out.println(alias + "----->" + map.get(alias));
        }
    }
}
