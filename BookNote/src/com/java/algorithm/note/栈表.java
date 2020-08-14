package com.java.algorithm.note;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: 栈表 .java
 * @Create : 2019-05-13-12:31
 * @Description :
 */
class DATA3{
    String name;
    int age ;

}
class StackType{
    static  final int MAXLEN=50;
    DATA3[] data = new DATA3[MAXLEN+1];
    int top;

    StackType STInit(){
        StackType p;
        //申请栈内存
        if ((p = new StackType()) != null) {
            p.top = 0;
            return p;
        }
        return null;
    }
    //判断栈是否为空
    boolean STIsEmpty(StackType s){
        boolean t;
        t = (s.top==0);
        return  t;
    }
    //判断栈是否已满
    boolean STIsFull(StackType s){
        boolean t;
        t = (s.top == MAXLEN);
        return  t;
    }
    //清空栈
    void STClear(StackType s){
        s.top = 0;
    }

    //释放栈所占用的空间
    void STFree(StackType s) {
        if (s != null) {
            s= null;
        }
    }

    // 入栈操作
    int PushST(StackType s, DATA3 data) {
        if ((s.top + 1) > MAXLEN) {
            System.out.println("栈溢出");
            return  0;
        }
        s.data[++s.top] = data;
        return 1;
    }

    //出栈操作
    DATA3 PopST(StackType s) {
        if (s.top == 0) {
            System.out.println("栈为空");
            System.exit(0);
        }
        return (s.data[s.top]);
    }

}
public class 栈表 {

    public static void main(String[] args) {

        StackType st = new StackType();
        DATA3 data1 = new DATA3();

        StackType stack = st.STInit();

        //出入栈
    }
}
