package com.study.example;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 *
 * @version : 1.0
 * @auther : Firewine
 * @mail ： 1451661318@qq.com
 * @Program Name: <br>
 * @Create : 2019-01-19-15:25
 * @Description :  <br/>
 */
public class MutilThreadDown {

    public static void main(String[] args) throws IOException {

        final  DownUtil downUtil = new DownUtil("https://s2.ax1x.com" + "/2019/01/14/Fx7CY6.png"
        ,"ios.png",4);

        downUtil.download();

        new Thread(()->{
            while (downUtil.getCompleteRate()<1){
                //每隔一段时间查询任务进度
                System.out.println("已完成" + downUtil.getCompleteRate());
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
