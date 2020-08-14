package com.study6.practice_6;

import com.study6.program_6.codesClass_6_6.ProcessArray;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-02-16:53
 */

public class Addable {



    public static void main(String[] args) {
        ProcessArray pa = new ProcessArray();

        int[] s = {3,1,2,5};

        pa.process(s,(int[] a)->{
            for (int tmp : a){
                System.out.println(tmp);
            }
        });
    }
}
