package com.study.program;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-02-17:28
 */
public class codes_18_2_CompileClassLoader extends ClassLoader{


    //读取一个文件的内容
    private byte[] getBytes(String filename) throws IOException{

        File file = new File(filename);
        long len = file.length();

        byte[] raw = new byte[(int)len];

        try(FileInputStream fin  = new FileInputStream(file)) {
               //一次读取Class文件的全部二进制数据
               int r = fin.read(raw);
               if(r != len)
               throw new IOException("无法读取全部文件："+r+"!=" + len);
        return raw;
        }
    }
    //定义编译指定java文件的方法
    private boolean compile (String javaFile)throws IOException{
        System.out.println("CompileClassLoader：正在编译" + javaFile +"...");
        //调用系统命令

        Process p = Runtime.getRuntime().exec("javac"+javaFile);
        try {
            //其他线程都等待这个线程完成
            p.waitFor();
        }catch (InterruptedException e){
            System.out.println(e);
        }
        //获取javac 线程的退出值
        int ret = p.exitValue();

        //返回编译是否成功
        return ret == 0;
    }
    //重写ClassLoader 的fIndClass方法
    protected Class<?> findClass (String name)throws ClassNotFoundException{
        Class clazz = null;

        //将包路径的点 替换成/

        String fileStub = name.replace(".","/");

        String javaFilename = fileStub + ".java";

        String classFilename = fileStub + ".class";

        File  javaFile = new File(javaFilename);

        File classFile = new File(classFilename);

        //当指定java源文件存在，且Class 文件不存在，或者java源文件
        //的修改时间比Class 文件的修改时间更晚时，重新编译
        if(javaFile.exists() && (!classFile.exists() || javaFile.lastModified() > classFile.lastModified())){
            try {
                //如果编译失败，或者该class文件不存在
                if (!compile(javaFilename) || !classFile.exists()){
                    throw new ClassNotFoundException("ClassNotFoundException:" + javaFilename);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        //如果Class 文件存在，系统负责将该文件转换成Class对象
        if (classFile.exists()){
            try {
                //将class 文件的二进制数据读入数组
                byte[] raw = getBytes(classFilename);
                //调用ClassLoader 的defineClass方法将二进制转换成Class对象

                clazz = defineClass(name,raw,0,raw.length);
            }catch (IOException oe){
                oe.printStackTrace();
            }
        }
        //如果clazz 为null  表明加载失败，则抛出异常
        if (clazz == null){
            throw new ClassNotFoundException(name);
        }
        return clazz;
    }

    //定义一个主方法
    public static void main(String[] args) throws Exception {


        //如果运行该程序时没有参数，即没有目标类
        if (args.length < 1) {
            System.out.println("缺少目标类，请按如下格式运行java源文件");
            System.out.println("java CompileClassLoader ClassName");

        }
        //第一个参数是需要运行的类
        String progClass = args[0];

        //剩下的参数将作为一个运行目标类时的参数
        //将这些参数复制到一个新数组中
        String[] proArgs = new String[args.length - 1];

        System.arraycopy(args, 1, proArgs, 0, proArgs.length);

        codes_18_2_CompileClassLoader ccl = new codes_18_2_CompileClassLoader();

        //加载运行的类
        Class<?> clazz = ccl.loadClass(progClass);
        //获取需要运行的类的主方法
        Method main = clazz.getMethod("main", (new String[0].getClass()));
        Object argArray[] = {proArgs};
        main.invoke(null, argArray);

    }


}
