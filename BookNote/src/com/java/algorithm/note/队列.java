package com.java.algorithm.note;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: 队列 .java
 * @Create : 2019-05-13-14:13
 * @Description :
 */
class DATA4 {
    String name;
    int age;
}

class SQType {

    static final int QUEUELEN = 15;
    DATA4[] data = new DATA4[QUEUELEN];
    int head;
    int tail;

    SQType SQTypeInit() {
        SQType q = new SQType();
        if (q != null) {
            q.head = 0;
            q.tail = 0;
            return q;
        } else {
            return null;
        }
    }

    // 判断空队列
    int SQTypeIsEmpty(SQType q) {
        int temp = 0;
        if (q.tail == q.head) {
            temp =1;
        }
        return temp;
    }

    //判断满队列
    int SQTypeIsFull(SQType q) {
        int temp = 0;
        if (q.tail == QUEUELEN) {
            temp =1;
        }
        return temp;
    }

    //清空队列
    void SQTypeClear(SQType q) {
        q.head = 0;
        q.tail = 0;
    }

    //释放队列
    void SQTypeFree(SQType q) {
        if (q != null) {
            q = null;
        }
    }

    //入队
    int InSQType(SQType q,DATA4 data){
        if (q.tail == QUEUELEN) {
            System.out.println("队列已满，操作失败");
            return 0;
        }else {
            q.data[q.tail++] =data;
            return 1;
        }
    }

    //出队列
    DATA4 OutSQType(SQType q){
        if (q.head == q.tail) {
            System.out.println("队列一空");
            System.exit(0);
        }else {
            return q.data[q.head++];
        }
        return null;
    }
    //读取结点数据
    DATA4 PeekSQType(SQType q){
        if (SQTypeIsEmpty(q) ==1){
            System.out.println("空队列");
            return  null;
        }else {
            return q.data[q.head];
        }
    }

    int SQTypeLen(SQType q){
        int temp;
        temp = q.tail - q.head;
        return temp;
    }
}

public class 队列 {

    public static void main(String[] args) {
        SQType st = new SQType();

        DATA4 data1;


        //下面操作省略
    }
}
