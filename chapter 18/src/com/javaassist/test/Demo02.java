package com.javaassist.test;

import javassist.*;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author : Firewine
 * @version : 1.0
 * @Program Name: Demo02
 * @Create : 2020/1/14
 * @Description :
 */
public class Demo02 {
    /**
     * 处理类的基本用法
     * @throws Exception
     */
    public static void test01() throws Exception{
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.bjsxt.test.Emp");

        byte[] bytes = cc.toBytecode();
        System.out.println(Arrays.toString(bytes));

        System.out.println(cc.getName()); //获取类名
        System.out.println(cc.getSimpleName()); //获取简要类名
        System.out.println(cc.getSuperclass()); //获得父类
        System.out.println(cc.getInterfaces()); //获得接口

    }

    /**
     * 测试产生新的方法
     * @throws Exception
     */
    public static void test02() throws Exception{
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.bjsxt.test.Emp");

//		CtMethod m = CtNewMethod.make("public int add(int a,int b){return a+b;}", cc);

        CtMethod m = new CtMethod(CtClass.intType,"add",
                new CtClass[]{CtClass.intType,CtClass.intType},cc);
        m.setModifiers(Modifier.PUBLIC);
        m.setBody("{System.out.println(\"www.sxt.cn\");return $1+$2;}");

        cc.addMethod(m);

        //通过反射调用新生成的方法
        Class clazz = cc.toClass();
        Object obj = clazz.newInstance();  //通过调用Emp无参构造器，创建新的Emp对象
        Method method = clazz.getDeclaredMethod("add", int.class,int.class);
        Object result = method.invoke(obj, 200,300);
        System.out.println(result);
    }

    /**
     * 修改已有的方法的信息，修改方法体的内容
     * @throws Exception
     */
    public static void test03() throws Exception{
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.bjsxt.test.Emp");

        CtMethod cm = cc.getDeclaredMethod("sayHello",new CtClass[]{CtClass.intType});
        cm.insertBefore("System.out.println($1);System.out.println(\"start!!!\");");
        cm.insertAt(9, "int b=3;System.out.println(\"b=\"+b);");
        cm.insertAfter("System.out.println(\"end!!!\");");

        //通过反射调用新生成的方法
        Class clazz = cc.toClass();
        Object obj = clazz.newInstance();  //通过调用Emp无参构造器，创建新的Emp对象
        Method method = clazz.getDeclaredMethod("sayHello", int.class);
        method.invoke(obj, 300);
    }

    /**
     * 属性的操作
     * @throws Exception
     */
    public static void test04() throws Exception{
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.bjsxt.test.Emp");

//		CtField f1 = CtField.make("private int empno;", cc);
        CtField f1 = new CtField(CtClass.intType,"salary",cc);
        f1.setModifiers(Modifier.PRIVATE);
        cc.addField(f1);

//		cc.getDeclaredField("ename");   //获取指定的属性

        //增加相应的set和get方法
        cc.addMethod(CtNewMethod.getter("getSalary", f1));;
        cc.addMethod(CtNewMethod.getter("setSalary", f1));;

    }

    /**
     * 构造方法的操作
     * @throws Exception
     */
    public static void test05() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("com.ces.test.Emp");

        CtConstructor[] cs = cc.getConstructors();
        for (CtConstructor c : cs) {
            System.out.println(c.getLongName());
        }
    }


    public static void test06() throws Exception{
        CtClass cc = ClassPool.getDefault().get("com.javaassist.test.Emp");
        Object[] all = cc.getAnnotations();
        Author a = (Author)all[0];
        String name = a.name();
        int year = a.year();
        System.out.println("name: " + name + ", year: " + year);

    }


    public static void main(String[] args) throws Exception {
        test06();
    }
}
