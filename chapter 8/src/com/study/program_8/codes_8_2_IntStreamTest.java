package com.study.program_8;

import java.util.stream.IntStream;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-20-14:51
 */
public class codes_8_2_IntStreamTest {
    public static void main(String[] args) {

        IntStream is = IntStream.builder()
                .add(20)
                .add(13)
                .add(15)
                .add(-5)
                .build();

        //下面的代码就是每次只能一次
        System.out.println("is所有元素的最大值,最小值，总数，平均值，所有的平方和是否大于20"+
                is.max().getAsInt()+" "+
                is.min().getAsInt()+" "+
                is.sum()+" "+
                is.count()+" "+
                is.allMatch(ele ->ele * ele >20));
        //上面的代码只能运行一个，

        IntStream newIs = is.map(ele -> ele * 2 + 1);

        newIs.forEach(System.out :: println);



    }
}
