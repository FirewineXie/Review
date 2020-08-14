package com.study.program;



import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-10-05-16:54
 */
public class codes_18_4_ExtendedObjectPoolFactory {


    //定义一个对象池，前面是对象名，后面是实际对象
    private Map<String ,Object> objectPool = new HashMap<>();
    private Properties config = new Properties();

    //从指定的属性文件中初始化Properties对象
    public void init(String filename){
        try(
            FileInputStream fis =  new FileInputStream(filename)){

            config.load(fis);

        }catch (IOException e){
            System.out.println("读取 " +filename+ "异常");
            e.printStackTrace();
        }
    }
    //定义一个创建对象的方法
    //该方法只要传入一个字符串类名，程序可以根据该类名生成java对象


    private Object createObject (String clazzName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        //根据字符串来获取对应的Class对象
        Class<?> clazz = Class.forName(clazzName);

        //使用clazz 对应类的默认构造器创建实例
        return clazz.getConstructor().newInstance();
    }

    //该方法根据指定文件来初始化对象池
    //他会根据配置文件来创建对象
    public void initPool() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        for (String name : config.stringPropertyNames()){
            //每取出一个key-value 对，如果key中不包括百分号
            //这就表明是根据value 来创建一个对象
            //调用createObject 创建对象，并将对象添加到对象池中

            if (!name.contains("%")){
                objectPool.put(name,createObject(config.getProperty(name)));
            }
        }
    }
    //该方法将会根据属性文件来调用指定对象的setter方法
    public void initProperty() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        for (String name :config.stringPropertyNames()){

            //每取出一对键值对，如果key含有百分号，
            //即可人文该key 用于控制调用对象的setter 方法设置值
            //% 前半为对象名字，后半控制setter 方法
            if (name.contains("%")){

                //将配置文件中的key按%分割
                String[] objANdProp = name.split("%");

                //取出调用setter 方法的参数值
                Object target = getObject(objANdProp[0]);
                //获取setter 方法名：set + “首字母大写” + 剩下部分
                String mtdName = "set" + objANdProp[1].substring(0,1).toUpperCase() + objANdProp[1].substring(1);

                //通过target 的getClass 获取它的实现类所对应的Class对象

                Class<?> targetClass = target.getClass();
                //获取希望调用的setter 方法
                Method mtd = targetClass.getMethod(mtdName,String.class);

                //通过method的invoke方法执行setter 方法
                //将config。getProperty（name） 的值作为调用setter 方法的参数
                mtd.invoke(target,config.getProperty(name));
            }
        }
    }

    private Object getObject(String s) {

        //从objectPool 中取出指定name对应的对象
        return objectPool.get(s);
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        codes_18_4_ExtendedObjectPoolFactory epf = new codes_18_4_ExtendedObjectPoolFactory();

        epf.init("D:\\IdeaProjects\\java\\src\\chapter 18\\src\\extObj.text");

        epf.initPool();
        epf.initProperty();
        System.out.println(epf.getObject("a"));
    }



}
