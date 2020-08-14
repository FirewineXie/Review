package com.study4.program_4;

/**
 * @Auther : xie     xyjworkgame@163.com
 * Program Name: <br>
 * @Version : 1.0
 * @Create : 2018-08-19-22:20
 */
public class ArraylnRam {

    public static void main(String[] args) {

        int[] a = {5,7,20};
        int[] b = new int[4];


        System.out.println("b的数组长度： " + b.length);

        for (int i = 0;i<a.length;i++){
            System.out.println(a[i]);
        }
        for (int i = 0;i<b.length;i++){
            System.out.println(b[i]);
        }

        //因为a是int类型，b也是int类型，所以可将a的值赋给b
        //也就是让b引用指向a引用指向的数组
        b = a;
        System.out.println("b 的长度：" + b.length);
    }
}
