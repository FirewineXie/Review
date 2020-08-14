package com.reflection.study;

/**
 * @author : Firewine
 * @version : 1.0
 * @Program Name: Demo01
 * @Create : 2020/1/13
 * @Description :
 */
public class Demo01 {

    public static void main(String[] args) {


        String path = "com.sxt.study.User";

        try {
            Class clazz = Class.forName(path);
            //对象是表示或封装一些数据。一个类被加载后，JVM会创建一个对应该类的Class 对象，类的整个结构信息会放到对象的Class对象
            //这个Class对象就像一面镜子一样，可以得到对应类的全部信息
            System.out.println(clazz);


            Class strCalss = String.class;
            Class strClasss2 = path.getClass();
            System.out.println(strCalss == strClasss2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
