package com.java.algorithm.note;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: 线性表 .java
 * @Create : 2019-05-10-10:12
 * @Description :
 */


class DATA {
    //结点关键字
    String key;
    String name;
    int age;
}

class SLType {

    /**
     * MAXLEN定义顺序表的最大长度
     */
    static final int MAXLEN = 100;

    /**
     *  保存顺序表的结构数组
     */
    DATA[] ListData = new DATA[MAXLEN + 1];
    /**
     * 顺序表已存结点的数量
     */
    int ListLen;
    /**
     * 初始化顺序表
     */
    void SLInit(SLType SL){
        //初始化为空表
        SL.ListLen = 0;
    }
    int SLLength(SLType SL){
        //返回顺序表的元素数量
        return (SL.ListLen);
    }
    int SLInsert(SLType SL , int n, DATA data){
        int i;
        //顺序表结点数量已超过最大数量
        if (SL.ListLen >= MAXLEN){
            System.out.println("顺序表已经满，不能插入");
            //返回0表示插入不成功
            return 0;
        }
        //插入结点序号不正确
        if (n <1 || n > SL.ListLen-1){
            System.out.println("插入元素序号错误");
            return 0;
        }
        //将顺序表的数据向后移动
        for (i=SL.ListLen;i >= n;i--){
            SL.ListData[i + 1] = SL.ListData[i];
            
        }
        //插入结点
        SL.ListData[n] = data;
        //结点数量加1
        SL.ListLen++;
        return 1;
    }
    //将数据添加到尾部
    int SlAdd(SLType SL,DATA data){
        if (SL.ListLen >= MAXLEN) {
            System.out.println("顺序表满了");
            return 0;
        }
        SL.ListData[++SL.ListLen] = data;
        return 1;
    }
    //删除顺序表中的数据
    int SLDelete(SLType SL, int n) {
        int i;
        if (n < 1 || n > SL.ListLen+1){
            System.out.println("删除节点序号错误");
            return 0;
        }
        // 将数据 向前移动
        for (i =n; i< SL.ListLen;i++){
            SL.ListData[i] = SL.ListData[i+1];
        }
        SL.ListLen--;
        return 1;
    }

    //根据序号返回数据元素
    DATA SLFindByNum(SLType SL, int n) {
        if (n < 1 || n > SL.ListLen) {
            System.out.println("节点序号错误");
            return null;
        }
        return SL.ListData[n];
    }

    //按关键字查询节点
    int SLFindByCont(SLType SL, String key) {
        int i;
        for (i = 1; i <= SL.ListLen; i++) {
            //如果找到所需节点
            if (SL.ListData[i].key.compareTo(key) ==0) {
                return 1;
            }
        }
        return 0;
    }
    //显示顺序表中的所有结点
    int SLAll(SLType SL){
        int i;
        for (i=1;i<=SL.ListLen;i++){
            System.out.printf("(%s,%s,%d)\n",SL.ListData[i].key,SL.ListData[i].name,SL.ListData[i].age);
        }
        return 0;
    }

}
public class 线性表 {
    public static void main(String[] args) {
        int i;
        //定义顺序表变量
        SLType SL = new SLType();
        //定义结点保存引用变量
        DATA pdata;
        //保存关键字
        String key;

        System.out.println("操作演示");
        SL.SLInit(SL);

        System.out.println("初始化完成");
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("输入添加的结点（学号，姓名，年龄）");
            DATA data = new DATA();
            data.key = input.next();
            data.name = input.next();
            data.age = input.nextInt();
            if (data.age != 0) {
                if (SL.SlAdd(SL, data) == 0) {
                    break;
                }
            } else {
                break;
            }
        } while (true);
        System.out.println("结点顺序");
        SL.SLAll(SL);


        System.out.println("要去出结点的序号");
        i= input.nextInt();
        pdata = SL.SLFindByNum(SL, i);
        if (pdata != null) {
            System.out.printf("第%个结点为：(%s,%s,%d)\n",i,pdata.name,pdata.age);
        }

        System.out.println("要查找的关键字");
        key = input.next();
        i = SL.SLFindByCont(SL, key);
        pdata = SL.SLFindByNum(SL, i);
        if (pdata != null) {
            System.out.printf("第%个结点为：(%s,%s,%d)\n",i,pdata.key,pdata.name,pdata.age);
        }
    }


}