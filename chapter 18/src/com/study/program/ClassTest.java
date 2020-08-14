package com.study.program;

import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-03-15:30
 */
//定义可重复注解
@Repeatable(Annos.class)
@interface Anno {}
@Retention(value = RetentionPolicy.RUNTIME)
@interface Annos{
    Anno[] value();
}
//使用四个注解修饰符类
@SuppressWarnings(value = "unchecked")
@Deprecated
//使用重复注解修饰该类
@Anno
@Anno
public class ClassTest {
    //为该类顶一个私有的构造器
    private ClassTest(){

    }

    //定义一个有参数的构造器
    public ClassTest(String name){
        System.out.println("执行有参数的构造");
    }

    //定义一个有参数的info方法
    public void  info(){
        System.out.println("执行无参数的info方法");
    }

    //定义一个有参数的info方法
    public void info(String str){
        System.out.println("执行有参数的info方法"+", 其str参数值 ： "  + str);
    }

    //定义个测试用的内部类

    class Inner{

    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {


        //下面代码可以获取ClassTest 对应的Class
        Class<ClassTest> clazz = ClassTest.class;
        //获取该类的全部构造器
        Constructor[] ctors = clazz.getDeclaredConstructors();
        System.out.println("ClassTest 的全部构造器：");
        for (Constructor c : ctors){
            System.out.println(c);
        }

        //获取该Class 对象所对应类的全部public构造器
        Constructor[] publicCtors = clazz.getConstructors();
        System.out.println("ClassTest 的全部public 构造器如下：");
        for (Constructor c :publicCtors){
            System.out.println(c);
        }

        //获取Class对象所对应类的全部public方法
        Method[] mtds = clazz.getMethods();
        System.out.println("ClassTest 的全部public方法如下：");
        for (Method md : mtds){
            System.out.println(md);
        }

        //获取该Class对象所对应类的指定方法
        System.out.println("ClassTest 里带一个字符串参数的info方法为："+clazz.getMethod("info",String.class));

        //获取该class对象所对应类的全部注解
        Annotation[] anns = clazz.getAnnotations();
        System.out.println("ClassTest 的全部Annotation如下：");

        for (Annotation an : anns){
            System.out.println(an);
        }

        System.out.println("该class 元素上的@SuppressWarning 注解为：" + Arrays.toString(clazz.getAnnotationsByType(SuppressWarnings.class)));

        System.out.println("该class 元素上的@Anno注解为；" +Arrays.toString(clazz.getAnnotationsByType(Anno.class)));

        //获取该Class对象所对应类的全部内部类
        Class<?>[] inners = clazz.getDeclaredClasses();
        System.out.println("ClassTest 的全部内部类：");
        for (Class c : inners){
            System.out.println(c);
        }
        //使用Class 。forname 方法加载ClassTest的Inner内部类
       Class inClazz = Class.forName("com.study.program.ClassTest$Inner");

        //通过getDeclaringClass 对应类的的外部类为
        System.out.println("InClass 对应类的内部类：" + inClazz.getDeclaringClass());

        System.out.println("ClassTest 的包：" + clazz.getPackage());

        System.out.println("ClassTest的父类 ：" + clazz.getSuperclass());
    }

}
