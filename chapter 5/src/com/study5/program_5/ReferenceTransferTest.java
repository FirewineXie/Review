package com.study5.program_5;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-21-21:17
 */
public class ReferenceTransferTest {

    public static void swap(Datawap datawap){
        int tmp = datawap.a;

        datawap.a = datawap.b;

        datawap.b = tmp;

        System.out.println("方法里面a和b的值为："+datawap.a+"\t"+datawap.b);
        datawap = null;
    }

    public static void main(String[] args) {

        Datawap datawap = new Datawap();
        datawap.a = 6;

        datawap.b = 7;
        swap(datawap);
        System.out.println("转换后的值："+datawap.a+"\t"+datawap.b);
    }
}
class Datawap{
    int a;
    int b;
}
