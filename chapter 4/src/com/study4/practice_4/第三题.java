package com.study4.practice_4;

import java.util.Scanner;

/**
 * @author : xie     xyjworkgame@163.com
 * Program Name: <br>
 * @version : 1.0
 * @create : 2018-08-20-19:02
 */
public class 第三题 {
    /**
     * 根据Math类，打印圆，，
     * @param r   圆心半径
     */
    public void printRound(int r){

        //假定圆心在坐标(r,r);
        int y = r * 2; //y的坐标开始
        int x = 0;
        int c = 0; //中间空格数量
        int z = 2; //每行递减量，因为在显示格内，竖行的距离差不多是横行距离的2倍
        for (int j = r * 2; j >= 0; j=j-z) {
            x = getX(r, y);
            System.out.print(getSpace(x) + "*");
            c = (r-x)*2;
            System.out.println(getSpace(c) + "*");
            y-=z;
        }
    }
    public static int getX(int r, int y) {
        //解圆标准方程的
        int x = y - r;
        double t = Math.sqrt((r * r) - (x * x));
        return (int) Math.round(r-t);
    }
    public static String getSpace(int i) {
        String s = "";
        for (int j = 0; j < i; j++) {
            s += " ";
        }
        return  s;
    }


    public static void main(String[] args) {
        第三题 d = new 第三题();
        System.out.print("请输入圆的半径（正整数）：");
        Scanner in = new Scanner(System.in);
        int radius=in.nextInt();
        d.printRound(radius); //
    }
}
