package com.study4.program_4;

import java.util.Arrays;

/**
 * @Auther : xie     xyjworkgame@163.com
 * Program Name: <br>
 * @Version : 1.0
 * @Create : 2018-08-20-12:52
 */
public class Num2RMB {

    private String[] hanArr = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};

    private String[] unitArr1 ={"十","百","千"};

    /**
     * 将浮点数转化成整数和小数部分
     * @param num 得到的浮点数
     * @return  返回出整数和小数部分
     */
    private String[] divide(double num){

        long num1 = (long)num;
        long num2 = Math.round((num - num1)* 100);
        //round 的作用：返回最接近 long的参数，其中 long四舍五入为正无穷大。

        return new String[]{num1+" ",String.valueOf(num2)};
        //String.valueOf:返回 long参数的字符串表示形式
    }

    /**
     * 将四位数的数字字符串变成汉子字符串
     * @param numstr  需要转换的字符串
     * @return  转换后的字符串
     */
    private String toHanStr1(String numstr){
        //这个方法，当头数字或者尾数字出现零的情况，结果不是自己想要的，需要重新判断
        String result ="";
        int numlen = numstr.length();

        //遍历得到每一位数字
        for (int i = 0;i<numlen;i++) {
            //char类型的转换成int类型的，ASCII码刚好相差48
            int num = numstr.charAt(i) - 48;
            //返回指定索引处的 char值

            //如果最后一位数字，而且数字不是零，则需要添加单位千百十
            if (i != numlen - 1 && num != 0) {

                result += hanArr[num] + unitArr1[numlen - 2 - i];

            } else {

                result += hanArr[num];
            }
        }
        return result;
    }
    private String toHanstr2(String numstr){

        String result = "";
        int[] num1 = new int[4];

        int numlen = numstr.length();//获取数字字符串的长度
//        System.out.println(numlen);

        for (int i = 0;i<numlen;i++) {
            //char类型的转换成int类型的，ASCII码刚好相差48
            int num= numstr.charAt(i) - 48;

            if (i != numlen - 1 && num != 0) {

                    result += hanArr[num] + unitArr1[numlen - 2 - i];

            } else {
               if (i == numlen -1 && num ==0) {
                   result += "";
               }else {
                       result += hanArr[num];
                }
            }
        }
            return  devlove(result);
    }
    private String devlove(String numstr){
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
    public static void main(String[] args) {
        Num2RMB nur = new Num2RMB();

        System.out.println(Arrays.toString(nur.divide(12345666787.123)));
        System.out.println(nur.toHanStr1("1003"));
        System.out.println(nur.toHanstr2("1230"));
    }
}
