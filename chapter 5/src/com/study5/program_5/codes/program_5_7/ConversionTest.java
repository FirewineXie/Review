package com.study5.program_5.codes.program_5_7;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-22-17:33
 */
public class ConversionTest {

    public static void main(String[] args) {

        double d = 13.4;
        long l= (long)d;

        System.out.println(l);

        int in = 5;

        //不能转换为boolean类型，会报错，
        //boolean p = (boolean)l;
        Object obj = "Hello";
        //obj 的变量的编译类型是OBject 这个与String继承关系，可以强制转换
        String objstr = (String)obj;

        System.out.println(objstr);

        //定义一个object变量，实例类型为Integer
        Object object = Integer.valueOf(5);

        //Object 与 Interger存在继承关系
        //可以强制转换，而object变量的实际类型是Interger
        //所以下面的代码会报错
        if (object instanceof String){

            String str = (String)object;
        }
        //可以使用instance判断是否可以转换，
        System.out.println(object instanceof String);
    }
}
