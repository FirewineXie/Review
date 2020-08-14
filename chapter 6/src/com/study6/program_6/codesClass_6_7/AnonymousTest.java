package com.study6.program_6.codesClass_6_7;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-02-11:51
 */
interface Product{
    public double getPrice();
    public String getName();
}
public class AnonymousTest {
    public void test(Product p){
        System.out.println("购买一个" + p.getName() +",花掉了"+ p.getPrice());
    }

    public static void main(String[] args) {
        AnonymousTest ta = new AnonymousTest();

        //调用test方法需要传入Protuct的参数
        ta.test(new Product() {
            @Override
            public double getPrice() {
                return 4546;
            }

            @Override
            public String getName() {
                return "显卡";
            }
        });
    }
}
