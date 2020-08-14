package com.java.algorithm.note;

import static com.java.algorithm.note.tree.MAXLEN;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: 树_四种遍历demo .java
 * @Create : 2019-05-13-17:40
 * @Description :
 */
public class 树_四种遍历demo {

    //按层遍历
    void LevelTree(CBTType treeNode) {
        CBTType p;
        //定义顺序栈
        CBTType[] q = new CBTType[MAXLEN];

        int head = 0, tail = 0;

        if (treeNode != null) {
            //计算循环队列队尾序号
            tail = (tail + 1) % MAXLEN;
            //将二叉树根引用进队
            q[tail] = treeNode;
        }
        //队列不为空，进行循环
        while (head != tail) {
            //计算循环队列的队首序号
            head = (head + 1) % MAXLEN;
            //获取队首元素
            p = q[head];
            //处理队首元素
            TreeNodeData(p);
            //如果结点存在左子树
            if (p.left != null) {
                //计算循环队列的队尾序号
                tail = (tail + 1) % MAXLEN;
                //将左子树引用进队
                q[tail] = p.left;
            }

            //如果结点存在右子树
            if (p.right != null) {
                //计算循环队列的队尾序号
                tail = (tail + 1) % MAXLEN;
                //将右子树引用进队
                q[tail] = p.right;
            }
        }
    }

    void TreeNodeData(CBTType p) {
        System.out.printf("%s", p.data);
    }
    //先序遍历
    void DLRTree(CBTType treeNode) {
        if (treeNode != null) {
            TreeNodeData(treeNode);
            DLRTree(treeNode.left);
            DLRTree(treeNode.right);
        }
    }

    //中序遍历
    void LDRTree(CBTType treeNode) {
        if (treeNode != null) {
            LDRTree(treeNode.left);
            TreeNodeData(treeNode);
            LDRTree(treeNode.right);
        }
    }
}
