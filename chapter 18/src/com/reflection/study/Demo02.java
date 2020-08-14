package com.reflection.study;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author : Firewine
 * @version : 1.0
 * @Program Name: Demo02
 * @Create : 2020/1/13
 * @Description :
 * 应用反射的API，获取类的信息
 */
public class Demo02 {

    public static void main(String[] args) {


        try {
            String path = "com.reflection.study.bean.User";
            Class clazz = Class.forName(path);


            //获取类的名字
            //获取包名和类名
            System.out.println(clazz.getName());
            //获取类名
            System.out.println(clazz.getSimpleName());

            //获取属性信息
            //只能获得public的field
            Field[] fields = clazz.getFields();
            System.out.println(fields.length);
            //获得其他属性例如private
            Field[] fields1 = clazz.getDeclaredFields();
            System.out.println(fields1.length);
            for (Field temp : fields1) {
                System.out.println(temp);
            }

            //获取方法信息
            Method[] method = clazz.getDeclaredMethods();

            Method m = clazz.getDeclaredMethod("getUname", null);
            //如果方法有参数，必须传输类型对应的class对象
            Method method1 = clazz.getMethod("setUname", String.class);

            //获得构造器的信息
            Constructor[] constructors = clazz.getDeclaredConstructors();
            for (Constructor temp : constructors) {
                System.out.println("构造器    " + temp);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
