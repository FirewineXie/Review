package com.study6.practice_6;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-02-16:43
 */
public interface Demo {

   String getName();
}
class min {

    public void info(Demo demo){
        System.out.println(demo.getName());

    }

    public static void main(String[] args) {

        min n = new min();
        n.info(new Demo() {
            @Override
            public String getName() {
                return "你好";
            }
        });
    }
}