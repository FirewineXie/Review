package com.java.algorithm.note;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: 链表 .java
 * @Create : 2019-05-10-11:00
 * @Description :
 */

class DATA2{
    String key;
    String name;
    int age;
}
class CLType{
    DATA2 nodeData = new DATA2();
    CLType nextNode;
    CLType CLAddEnd(CLType head,DATA2 nodeData){
        CLType node,htemp = null;
        if ((node = new CLType()) == null) {
            System.out.println("申请内存失败");
            return null;
        }else {
            //保存数据
            node.nodeData = nodeData;
            //设置结点引用为空，即为表尾
            node.nextNode = null;
            //头引用
            if (head == null) {
                head = node;
                return head;
            }
            htemp.nextNode = head;
            //查找链表的末尾
            while (htemp.nextNode != null) {
                htemp = htemp.nextNode;
            }
            htemp.nextNode = node;
            return head;

        }
    }

    CLType ClAddFirst(CLType head, DATA2 nodeData) {
        CLType node;
        if ((node = new CLType()) == null) {
            System.out.println("申请内存失败");
            return  null;
        }else{
            //保存数据
            node.nodeData = nodeData;
            //指向头引所指结点
            node.nextNode = head;
            //头引用指向新增结点
            head= node;
            return head;
        }
    }
    //查找节点
    CLType CLFindNode(CLType head, String key) {
        CLType htemp;
        //保存链表头引用
        htemp = head;
        //若节点有效，则查找
        while (htemp != null) {
            if (htemp.nodeData.key.compareTo(key) == 0){
                return htemp;
            }
            htemp = htemp.nextNode;
        }
        return null;
    }
    //插入结点
    CLType CLInsertNode(CLType head, String findkey, DATA2 nodeData) {
        CLType node,nodetemp;
        if ((node = new CLType()) == null) {
            System.out.println("申请内存失败");
            return null;
        }
        node.nodeData = nodeData;
        nodetemp = CLFindNode(head,findkey);
        if (nodetemp != null){
            //新插入结点指向关键节点的下一节点
            node.nextNode = nodetemp.nextNode;
            //设置关键节点指向新插入结点
            nodetemp.nextNode=node;
        }else {
            System.out.println("未找到正确的插入位置");
            //释放内存
            //free(node);
        }
        return head;
    }
    //删除结点
    int CLDeleteNode(CLType head,String key){
        CLType node,htemp;
        htemp = head;
        node = head;
        while (htemp != null){
            if (htemp.nodeData.key.compareTo(key) == 0){
                node.nextNode=htemp.nextNode;
                return 1;
            }else {
                node = htemp;
                htemp = htemp.nextNode;
            }
        }
        return 0;
    }
    int CLLength(CLType head){
        CLType htemp;
        int len= 0;
        htemp = head;
        while (htemp != null) {
            len++;
            htemp = htemp.nextNode;

        }
        return len;
    }

    //遍历
    void CLAllNode(CLType head) {
        CLType htemp;
        DATA2 nodeData;
        htemp = head;
        System.out.printf("当前链表共有%d个节点，链表所有数据如下，\n",CLLength(head));
        while (htemp != null) {
            //获取结点数据
            nodeData = htemp.nodeData;
            System.out.printf("结点(%s,%s,%d)\n",nodeData.key,nodeData.name,nodeData.age);
            htemp = htemp.nextNode;

        }
    }
}
public class 链表 {

    public static void main(String[] args) {

        CLType node, head=null;
        CLType CL = new CLType();
        String key,findkey;
        Scanner input = new Scanner(System.in);

        System.out.println("链表测试 格式 ： 关键字，姓名，年龄");
        do {
            DATA2 nodeData = new DATA2();
            nodeData.key = input.next();
            if (nodeData.key.equals("0")) {
                break;
            } else {
                nodeData.name = input.next();
                nodeData.age = input.nextInt();
                //在链表尾部添加结点
                head = CL.CLAddEnd(head, nodeData);

            }

        } while (true);
        CL.CLAllNode(head);
        System.out.printf("\n 演示插入结点，输入插入位置关键字：");
        findkey = input.next();
        System.out.println("输入节点的数据（关键字，姓名，年龄）");
        DATA2 nodeData = new DATA2();
        nodeData.key = input.next();
        nodeData.name = input.next();
        nodeData.age = input.nextInt();
        head = CL.CLInsertNode(head, findkey, nodeData);
        CL.CLAllNode(head);
    }
}
