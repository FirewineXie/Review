package com.study6.program_6.codesClass_6_8;

import com.study6.program_6.codesClass_6_6.Command;
import com.study6.program_6.codesClass_6_6.ProcessArray;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-02-12:32
 */
public class CommandTest {

    public static void main(String[] args) {

        /**
         * 下面的方法的本质都是一样的，但是运用lambda更加的方便和间接，只要给出重写的方法括号，及括号里的形参列表即可
         *
         *
         */
        ProcessArray pa = new ProcessArray();
        int[] target = {-3,-4,5,6};
        pa.process(target, new Command() {
            @Override
            public void process(int[] target) {
                int sum = 0;
                for (int tmp : target){
                    sum += tmp;
                }
                System.out.println("综合："+sum);
            }
        });

        ProcessArray pb = new ProcessArray();

        pb.process(target,(int[] t1)->{
            int sum = 0;
            for (int tmp : t1){
                sum += tmp;
            }
            System.out.println(sum);
        });
    }
}
