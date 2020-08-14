package com.study.program;

import com.sun.org.apache.xml.internal.utils.ObjectPool;

import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-05-16:13
 */
public class codes_18_4_ObjectPoolFactory {


    //定义一个对象池，前面是对象名，后面是实际对象
    private Map<String ,Object> objectPool = new HashMap<>();

    //定义一个创建对象的方法
    //该方法只要传入一个字符串类名，，程序就可以根据该类名生成java对象

    private Object createObject (String clazzName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        //根据字符串来获取对应的Class对象
        Class<?> clazz = Class.forName(clazzName);

        //使用clazz 对应类的默认构造器创建实例
        return clazz.getConstructor().newInstance();
    }
    //该方法根据指定文件来初始化对象池
    //它会根据配置文件来创建对象
    public void initPool(String filename){
        try(FileInputStream fis = new FileInputStream(filename)){

            Properties properties = new Properties();
            properties.load(fis);

            for (String name : properties.stringPropertyNames()){
                //每取出一对key-value 对，就根据value 创建一个对象
                //调用createObject 创建对象，并将对象添加到对象池中
                objectPool.put(name ,createObject(properties.getProperty(name)));
            }
        }catch (Exception e){
            System.out.println("读取"+filename+"异常");
            e.printStackTrace();
        }
    }
    public Object getObject(String name){
        //从ObjectPool 中取出指定name对应的对象
        return objectPool.get(name);
    }

    public static void main(String[] args) {
        codes_18_4_ObjectPoolFactory pf = new codes_18_4_ObjectPoolFactory();
        pf.initPool("D:\\IdeaProjects\\java\\src\\chapter 18\\src\\obj.txt");

        System.out.println(pf.getObject("a"));
        System.out.println(pf.getObject("b"));
    }
}
