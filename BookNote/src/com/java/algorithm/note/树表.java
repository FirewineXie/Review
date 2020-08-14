package com.java.algorithm.note;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: 树表 .java
 * @Create : 2019-05-13-17:41
 * @Description :
 */
// 定义二叉树结点类型
class CBTType {
    //数据，左，右
    String data;
    CBTType left;
    CBTType right;
}

class tree {
    static final int MAXLEN = 20;
    static Scanner input = new Scanner(System.in);

    CBTType IniTree() {
        CBTType node;
        if ((node = new CBTType()) != null) {
            System.out.println("请输入一个根节点的数据");
            node.data = input.next();
            node.left = null;
            node.right = null;
            //如果二叉树结点不为空
            if (node != null) {
                return node;
            } else {
                return null;
            }
        }
        return null;
    }

    //添加结点
    void AddTreeNode(CBTType treeNode) {
        CBTType pnode, parent;
        String data;
        int menusel;

        if ((pnode = new CBTType()) != null) {
            System.out.println("输入二叉树结点数据");
            pnode.data = input.next();
            pnode.left = null;
            pnode.right = null;

            System.out.println("输入该节点的父节点数据");
            data = input.next();
            //查找指定数据的结点
            parent = TreeFinNode(treeNode, data);
            if (parent == null) {
                System.out.println("未找到该父节点");
                pnode = null;
                return;
            }
            System.out.println("1.添加该节点到左子树\n 2.添加该节点到右子树");
            do {
                menusel = input.nextByte();
                if (menusel == 1 || menusel == 2) {
                    if (parent == null) {
                        System.out.println("不存在父节点，请先设置父节点");
                    } else {
                        switch (menusel) {
                            case 1:
                                if (parent.left != null) {
                                    System.out.println("左子树不能为空");
                                } else {
                                    parent.left = pnode;
                                }
                                break;
                            case 2:
                                if (parent.right != null) {
                                    System.out.println("右子树结点不为空");
                                } else {
                                    parent.right = pnode;
                                }
                                break;
                            default:
                                System.out.println("无效参数");
                        }
                    }
                }
            } while (menusel != 1 && menusel != 2);
        }
    }

    //查找节点
    CBTType TreeFinNode(CBTType treeNode, String data) {
        CBTType ptr;
        if (treeNode == null) {
            return null;
        } else {
            //左右子树递归查找
            if (treeNode.data.equals(data)) {
                return treeNode;
            } else {
                if ((ptr = TreeFinNode(treeNode.left, data)) != null) {
                    return ptr;
                } else if ((ptr = TreeFinNode(treeNode.right.right, data)) != null) {
                    return ptr;
                } else {
                    return null;
                }
            }
        }
    }

    //获取左子树
    CBTType TreeLeftNode(CBTType treeNode) {
        if (treeNode != null) {
            return treeNode.left;
        } else {
            return null;
        }
    }

    //获取右子树
    CBTType TreeRightNode(CBTType treeNode) {
        if (treeNode != null) {
            return treeNode.right;
        } else {
            return null;
        }
    }

    //判断空树
    int TreeeIsEmpty(CBTType treeNode) {
        if (treeNode != null) {
            return 0;
        } else {
            return 1;
        }
    }

    //计算二叉树深度
    int TreeDepth(CBTType treeNode) {
        int depleft, depright;
        if (treeNode == null) {
            return 0;
        } else {
            depleft = TreeDepth(treeNode.left);
            depright = TreeDepth(treeNode.right);
            if (depleft > depright) {
                return depleft + 1;
            } else {
                return depright + 1;
            }
        }
    }

    //清空二叉树
    void ClearTree(CBTType treeNode) {
        if (treeNode != null) {
            ClearTree(treeNode.left);
            ClearTree(treeNode.right);
            treeNode = null;
        }
    }

    //显示结点数据
    void TreeNodeData(CBTType p) {
        System.out.printf("%s", p.data);
    }

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

    //后续遍历
    void LRDTree(CBTType treeNode) {
        if (treeNode != null) {
            LRDTree(treeNode.left);
            LRDTree(treeNode.right);
            TreeNodeData(treeNode);
        }
    }
}

public class 树表 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CBTType root = null;
        int mensusel;

        tree t = new tree();
        root = t.IniTree();

        //添加结点
        do {
            System.out.println("请选择菜单添加二叉树的结点\n");
            System.out.printf("0.退出\t");
            System.out.printf("1.添加二叉树的结点");
            mensusel = input.nextInt();
            switch (mensusel) {
                case 1:
                    t.AddTreeNode(root);
                    break;
                case 0:
                    break;
                default:
                    ;
            }
        } while (mensusel != 0);


        //遍历
        System.out.println("选择三种遍历，这里不再写出");
    }
}
