package com.study4.practice_4;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * Program Name: <br>
 * @Create : 2018-08-20-22:11
 */
public class 第四题 {
    /**
     * 做出与subString相似的功能，但是与subString不同的是：要求字节截取
     * 一个英文的字节算一个，一个中文字符算两个字符
     * @param str  输入想要截取的字符串
     * @param indexstart   输入开头的字符序号
     * @param lengths  所要截取的字节长度
     */
    public void   subStr(String str,int indexstart,int lengths){
        /**
         * 在这不考虑，汉子恰好被分隔的情况
         *            输入的数字是在范围的之外，导致错误
         *            重要的解决的问题。
         */


        String str1 = "";
        //新建一个数组，用来存放截取的数组

        //首先确定indexstart的位置
        for (int i = indexstart;i<str.length();i++){
            str1 +=str.charAt(i);
        }
        int num ;
        //将确定后的字符串转换为字节数组
        byte[] bytes = str1.getBytes();

        if (bytes[lengths] < 0){
           lengths = lengths + 1;
        }
        if (lengths > bytes.length){
            lengths = bytes.length;
        }

        //再将截取后的字节数组，转换为字符串
        String string = new String(bytes,0,lengths);
        System.out.println(str1+"  "+string);

    }

    public static void main(String[] args) {

        第四题 d = new 第四题();

        d.subStr("国家aaa,dd",1,4);
    }
}
