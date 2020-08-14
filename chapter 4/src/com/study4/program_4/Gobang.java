package com.study4.program_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * @Auther : xie     xyjworkgame@163.com
 * Program Name: <br>
 * @Version : 1.0
 * @Create : 2018-08-20-15:43
 */
public class Gobang {
    //定义棋盘的大小
    private  static  int BOARD_SIZE = 15;

    //定义一个二维数组充当棋盘
    private String[][] board;

    public void  initBoard(){
        //初始化棋盘数组
        board = new String[BOARD_SIZE][BOARD_SIZE];
        //把每个元素赋为+  用于在控制台画出棋盘

        for(int i =0;i < BOARD_SIZE;i++){
           for (int j =0; j <BOARD_SIZE;j++){
               board[i][j] ="┿";
           }
        }
    }

    //在控制台输出棋盘的方法
    public void printBoard(){
        for (int i = 0;i < BOARD_SIZE;i++){
            for (int j = 0;j <BOARD_SIZE;j++){

                System.out.printf(board[i][j]);
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args)throws Exception {
        //main  方法抛出异常，表示不处理任何异常
        Gobang gb = new Gobang();
        gb.initBoard();
        gb.printBoard();

        //这是获取建安输入的方法

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = null;
        //每当输入一行，回车键，会被读到
        while ((inputStr = br.readLine()) != null){
            //将用户输入到的字符串以逗号隔开
            String[] posStrArr = inputStr.split(",");
            //奖两个字符串转换成用户下棋的坐标
            int xPos = Integer.parseInt(posStrArr[0]);
            int yPos = Integer.parseInt(posStrArr[1]);

            //把对应的数组元素赋为●
            gb.board[yPos -1][xPos - 1] = "●";
            /*
                电脑随机生成2个整数，作为坐标，赋给board数组
                还涉及：
                    1.坐标的有效性，只能是数字，而且不能超出范围
                    2.下的棋的点，不能重复下
                    3.每次下完，需要扫描
             */
            gb.printBoard();
            System.out.println("请输入您下的坐标，以x，y的格式：");
        }
    }
}
