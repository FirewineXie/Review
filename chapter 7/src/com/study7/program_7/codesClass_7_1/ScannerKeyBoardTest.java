package com.study7.program_7.codesClass_7_1;

import java.io.File;
import java.util.Scanner;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-02-18:02
 */
public class ScannerKeyBoardTest {

    public static void main(String[] args) throws Exception {

//        Scanner sc = new Scanner(System.in);

        Scanner sc = new Scanner(new File("ScannerKeyBoardTest.java"));
//        sc.useDelimiter("\n");//通过这个方法来确定用什么分隔符
//
//        while (sc.hasNext()){
//            System.out.println("输入键盘的内容是  "+sc.next());
//
//        }
//        while (sc.hasNextLong()){
//            System.out.println("输入键盘的内容是  "+sc.nextLong());
//        }
        while (sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
    }
}
