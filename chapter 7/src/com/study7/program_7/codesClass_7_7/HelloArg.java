package com.study7.program_7.codesClass_7_7;

import java.security.MessageDigest;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-04-11:01
 */
public class HelloArg {

    public static void main(String[] args) {

        Locale locales= null;

        if (args.length == 2){
            locales = new Locale(args[0] ,args[1]) ;
        }else {
            locales = Locale.getDefault(Locale.Category.FORMAT);
        }


        //加载语言资源
        ResourceBundle bundle = ResourceBundle.getBundle("mymess",locales);

        String  msg = bundle.getString("msg");

        System.out.println(MessageFormat.format(msg,"yeeku",new Date()));
        /*
            MessageFormat .format 可以利用配置文件进行填充预留下的占位符，，填充想要填写的东西
         */
    }
}
