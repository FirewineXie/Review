package com.study4.practice_4;

import java.security.PrivateKey;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-21-13:12
 */
public class 第五题 {

    private String[] hArr = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
    private String[] uhArr  ={"拾","佰","仟"};
    private String[] unArr = {"分","角"};


    public void numcon(double n){
        /**
         *
         * 格式化浮点数
         */

        long rmb1 = (long)n;  //整数部分

        long rmb2 = Math.round((n - rmb1)*100);//小数部分，为两位




    }
    private String RMB1(int n){

        String result ="";
        String leng ="";
        //把数字变成字符串
        while(n != 0){
            leng += n % 10;

            n = n /10;
        }
        //改变整数为rmb叫法字符串
        for (int i = 0;i<leng.length();i++){
            int num = leng.charAt(i) - 48;
            if (i != leng.length()-1 && num != 0 ){
                result = hArr[num] + uhArr[leng.length() -i +1];
            }else {
                if (i == 3 && num ==0){
                    result += "";
                }else {
                    result += hArr[num];
                }
            }
        }
        return devide(result);
    }
    private String devide(String numstr){
        String result = ""; // 存放复制结果
        int len = numstr.length();
        for(int i = 0; i < len; i++) // 遍历转换完而未修整去零的字符串
        {
            if (numstr.charAt(i) != '零')  {
                result += numstr.charAt(i);
            } // 非'零'字符,直接复制
            else if(i != numstr.length() - 1  && numstr.charAt(i + 1) != '零') {

                result += numstr.charAt(i);
            }
        }
        return result;

    }
    private String RMB2(int n){

        String result = "";
        String leng = "";

        while (n != 0){
            leng += n%10;

            n = n/10;
        }

        for (int i= 0; i<leng.length();i++){
            int num = leng.charAt(i);
            if (i != leng.length() -1 && num != 0){
                result += uhArr[num] + unArr[leng.length() - i -1];
            }else {
                result += uhArr[num];
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
