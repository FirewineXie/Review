package com.study.program;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-28-15:23
 */
public class codes_10_4_ThrowTest {

    public static void main(String[] args) {

        try{
            //调用声明抛出Checked异常的方法，要么显示捕获该异常
            //要么在main中再次声明抛出
            throChecked(-4);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        throwRuntime(3);
    }
    public static void throChecked(int a) throws Exception{
        if (a > 0){
            //自行抛出异常
            //该代码必须处于try快里，或处于待throws声明的方法中
            throw new Exception("a 的值 大于0 ，不符合要求");
        }
    }
    public static void throwRuntime(int a){
        if (a > 0){
            //自行抛出RuntimeException异常，
            // 既可以显示捕获处理异常，也可以不理会异常，交给该异常的该方法调用者处理
            throw new RuntimeException("a 的值大于0 ，不符合要求");
        }
    }

}
