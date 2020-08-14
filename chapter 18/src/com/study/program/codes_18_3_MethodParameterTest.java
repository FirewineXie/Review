package com.study.program;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-05-15:57
 */
class Test{
    public void replace(String str, List<String> list){}
}
public class codes_18_3_MethodParameterTest {
    public static void main(String[] args) throws NoSuchMethodException {



        //获取String的类
        Class<Test> clazz = Test.class;

        //获取String类的带两个参数的Replace 方法
        Method replace = clazz.getMethod("replace", String.class, List.class);

        //获取指定方法的参数个数
        System.out.println("replace 方法参数个数" +replace.getParameterCount());

        //获取replace 的所有参数信息
        /**
         * 为什么没有打印出形参信息，因为，javac默认是不打印出形参的，如果想要打印需要添加 -parameters
         */
        Parameter[] parameters = replace.getParameters();
        int index = 1;

        //遍历所有参数
        for (Parameter p : parameters){
            if (p.isNamePresent()){
                System.out.println("---第"+index++ + "个参数信息----");
                System.out.println("参数名：" + p.getName());
                System.out.println("形参类型：" + p.getType());
                System.out.println("泛型类型：" + p.getParameterizedType());

            }
        }
    }
}
