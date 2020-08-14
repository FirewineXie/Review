package com.java.algorithm.note;

import java.util.Scanner;

public class Graph {
    static Scanner input = new Scanner(System.in);

    //创建邻接矩阵
    static void CreateGraph(GraphMatrix GM) {
        int i, j, k;
        int weight; //权
        char EstartV, EndV;//边的起始顶点

        System.out.println("输入图中个顶点信息");
        for (i = 0; i < GM.VertexNum; i++) {
            System.out.printf("输入图中各顶点信息\n");
            GM.Vertex[i] = (input.next().toCharArray())[0];//保存到个顶点数据元素汇总

        }
        System.out.println("输入各构成各边的顶点及权值\n");
        //输入各边信息
        for (k = 0; k < GM.EdgeNum; k++) {
            System.out.printf("第%d跳变：", k + 1);
            EstartV = input.next().charAt(0);
            EndV = input.next().charAt(0);
            weight = input.nextInt();
            //在已有顶点中查找开始点
            for (i = 0; EstartV != GM.Vertex[i]; i++) {
                ;
            }
            //查找终结点
            for (j = 0; EndV != GM.Vertex[j]; j++) {
                ;
            }
            //对应位置保存权值，表示有一条边
            GM.EdgeWeight[i][j] = weight;

            if (GM.GType==0) {
                //在对角位置保存权值
                GM.EdgeWeight[j][i] = weight;
            }
        }
    }

    //清空矩阵
    static void ClearGraph(GraphMatrix GM) {
        int i,j;
        for (i = 0; i < GM.VertexNum; i++) {
            for (j = 0; j < GM.VertexNum; j++) {
                GM.EdgeWeight[i][j] = GraphMatrix.MaxValue;
            }
        }
    }

    //输出邻接矩阵
    static void OutGraph(GraphMatrix GM) {
        int i,j;
        for (j = 0; j < GM.VertexNum; j++) {
            //顶点信息
            System.out.printf("\t%c",GM.Vertex[j]);
        }
        System.out.println("\n");
        for (i = 0; i < GM.VertexNum; i++) {
            System.out.printf("%c", GM.Vertex[i]);
            for (j = 0; i < GM.VertexNum; j++) {
                //若权值最大值
                if (GM.EdgeWeight[i][j] == GraphMatrix.MaxValue) {
                    System.out.printf("\tZ");
                }
                else {
                    System.out.printf("\t%d", GM.EdgeWeight[i][j]);
                }
            }
            System.out.printf("\n");
        }
    }

    //从n个节点开始，深度遍历图
    static void DeepTraOne(GraphMatrix GM, int n) {
        int i;
        GM.isTrav[n] = 1;//表示该顶点已经处理过
        System.out.printf("->%c", GM.Vertex[n]);

        //添加处理节点操作
        for (i = 0; i < GM.VertexNum; i++) {
            if (GM.EdgeWeight[n][i] != GraphMatrix.MaxValue && GM.isTrav[n] == 0) {
                DeepTraOne(GM,i);
            }
        }
    }

    //深度优先遍历
    static void DeepTraGraph(GraphMatrix GM) {
        int i;
        for (i = 0; i < GM.VertexNum; i++) {
            //清楚个顶点遍历标志
            GM.isTrav[i] =0;
        }
        //开始
        for (i = 0; i < GM.VertexNum; i++) {
            if (GM.isTrav[i] == 0) {
                DeepTraOne(GM,i);
            }
        }
        System.out.printf("\n");
    }





    public static void main(String[] args) {


        GraphMatrix GM = new GraphMatrix();

        Scanner input = new Scanner(System.in);
        System.out.println("输入生成图类型");
        GM.GType = input.nextInt();

        System.out.println("输入图的顶点数量");
        GM.VertexNum = input.nextInt();

        System.out.println("输入图的边数");
        GM.EdgeNum =input.nextInt();

        ClearGraph(GM);

        CreateGraph(GM);

        System.out.println("数据如下");
        OutGraph(GM);
        DeepTraGraph(GM);
    }
}
