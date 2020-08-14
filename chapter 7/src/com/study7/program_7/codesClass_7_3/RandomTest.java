package com.study7.program_7.codesClass_7_3;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-03-10:56
 */
public class RandomTest {

    public static void main(String[] args) {

        Random r = new Random();
        System.out.println(r.nextBoolean());

        byte[] buffer = new byte[16];

        r.nextBytes(buffer);

        System.out.println(Arrays.toString(buffer));

        //还有等等方法，可以看api


        //如果这个类的两个实例是用一个种子创建的，，会产生一样的序列
        Random r1 = new Random(40);
        Random r2 = new Random(40);

        System.out.println(r1.nextInt() == r2.nextInt());


        ThreadLocalRandom random =  ThreadLocalRandom.current();

        System.out.println(random.nextInt(4,20));
    }
}
