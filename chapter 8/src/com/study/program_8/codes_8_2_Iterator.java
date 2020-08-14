package com.study.program_8;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;


/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-20-13:32
 */
public class codes_8_2_Iterator {
    public static void main(String[] args) {

        //创建集合
        Collection c = new HashSet();

        for (int i=1;i<6;i++){
            c.add(i);
        }

        Iterator it = c.iterator();
        while (it.hasNext()){
            //it.next 方法返回的数据类型是object类型，因此需要强制类型转换
            //但是强制类型转换会报错，，可以使用toString来转换
            String book = it.next().toString();
            System.out.println(book);

            if (book.equals("1")){
                //从集合中删除上一次next方法返回的元素
                it.remove();
            }
            //对book进行变量赋值，不会改变集合元素的本身
            book = "55";
        }

        System.out.println(c);
    }
}
