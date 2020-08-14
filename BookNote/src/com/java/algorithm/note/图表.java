package com.java.algorithm.note;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: 图表 .java
 * @Create : 2019-05-14-16:38
 * @Description :
 */
class GraphMatrix {
    static final int MaxNum = 20;
    static final int MaxValue = 65535;
    //保存顶点信息
    char[] Vertex = new char[MaxNum];
    //图的类型1 有向，0无向
    int GType;
    // 顶点数量
    int VertexNum;
    //边的数量
    int EdgeNum;
    //保存边的权
    int[][] EdgeWeight = new int[MaxNum][MaxNum];
    //遍历标志
    int[] isTrav = new int[MaxNum];

}


