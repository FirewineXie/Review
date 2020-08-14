package com.study7.practice_7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-04-14:23
 */
public class Three {

    public static void main(String[] args) {

        String str = "A1B2C3D4E5F6G7H8";
        Pattern p1 = Pattern.compile("\\d");
        Matcher m1 = p1.matcher(str);

        int[] st1 = new int[8];
        for (int i =0;m1.find();i++){
            st1[i] = i;
        }

        Pattern p2=Pattern.compile("\\D");
        Matcher m2=p2.matcher(str);
        String[] arrStr=new String[8];
        for(int i=0;m2.find();i++)
        {
            arrStr[i]=m2.group();
            //System.out.print(m1.group());
        }
        //Homework3 hw3=new Homework3();



    }
}
