package com.reflection.study;

import com.reflection.study.bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author : Firewine
 * @version : 1.0
 * @Program Name: Demo03
 * @Create : 2020/1/13
 * @Description :
 */
public class Demo03 {

    public static void main(String[] args) {

        String path = "com.reflection.study.bean.User";
        try {
            Class<User> clazz = (Class<User>) Class.forName(path);

            //通过反射API调用构造方法，构造对象
            //其实是调用了User的无参构造方法
            User u = (User) clazz.newInstance();
            System.out.println(u);

            //指定通过构造器调用
            Constructor<User> c = clazz.getDeclaredConstructor(int.class, int.class, String.class);
            //System.out.println(c);
            User u2 = c.newInstance(101, 18, "测试i");

            System.out.println(u2.getUname());

            //通过反射API 调用普通方法
            User u3 = clazz.newInstance();
            //u3.setUname("岑石3");,下面类似于注释作用
            Method method = clazz.getDeclaredMethod("setUname", String.class);
            method.invoke(u3, "岑石3");
            System.out.println(u3.getUname());


            //通过API操作属性
            User u4 = clazz.newInstance();
            Field f = clazz.getDeclaredField("uname");
            //这个属性不需要做安全检查了，可以直接访问
            //通过反射直接读取属性
            f.setAccessible(true);
            f.set(u4, "岑石4");
            System.out.println(u4.getUname());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }
}
