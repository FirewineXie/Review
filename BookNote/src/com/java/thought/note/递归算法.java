package com.java.thought.note;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: 递归算法 .java
 * @Create : 2019-05-15-20:10
 * @Description :
 */
public class 递归算法 {

    static long fact(int n) {
        if (n <=1){
            return 1;
        }else {
            return n * fact(n - 1);
        }
    }

    public static void main(String[] args) {


    }
}
