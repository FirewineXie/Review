package com.javaScript.practice;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

/**
 * @author : Firewine
 * @version : 1.0
 * @Program Name: Demo01
 * @Create : 2020/1/14
 * @Description : 测试脚本引擎执行JavaScript代码
 */
public class Demo01 {


    public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException {


        //获得脚本引擎对象
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("javascript");

        //定义变量
        engine.put("msg", "测试  demo");
        String str = "var user={name:'ceshi',age:'18',schools:['清华','北大']};";
        str += "print(user.name);";


        //执行
        engine.eval(str);
        engine.eval("msg = 'ceshi is a good demo';");
        System.out.println(engine.get("msg"));


        //定义函数
        engine.eval("function add(a,b){var sum = a+b; return sum;}");

        //执行函数
        Invocable jsInvoke = (Invocable) engine;
        Object result1 = jsInvoke.invokeFunction("add",new Object[]{13,20});
        System.out.println(result1);

        //导入其他java包，使用其他包中的java类.若需要深入了解细节，可以详细学习Rhino的语法
        // String jsCode = "importPackage(java.util); var list=Arrays.asList([\"北京尚学堂\",\"清华大学\",\"北京大学\"]);";
        // engine.eval(jsCode);
        //
        // List<String> list2 = (List<String>)engine.get("list");
        // for (String temp : list2) {
        //     System.out.println(temp);
        // }

        //执行一个js文件(我们将a.js至于项目的src下即可)
        URL url = Demo01.class.getClassLoader().getResource("a.js");
        FileReader fr = new FileReader(url.getPath());
        engine.eval(fr);
        fr.close();   //由于只是测试，就不那么规范了。大家实际用时要使用try catch finally！


    }
}
