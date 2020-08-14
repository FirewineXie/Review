package com.study6.program_6.codesClass_6_7;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-31-19:22
 */
public class Cow {
    private double weight;

    public Cow(){}
    public Cow(double weight){
        this.weight = weight;
    }

    //定义一个非静态内部类
    private class CowLog{

        private double length;
        private String color;

        public CowLog(){}
        public CowLog(double length, String color){
            this.length = length;
            this.color = color;
        }

        public double getLength() {
            return length;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        private void info(){
            System.out.println("当前牛腿的颜色："+color+", 高："+length);
            System.out.println("本牛腿的重量是："+weight);
        }
    }

    private void test(){
        CowLog cl = new CowLog(1.12,"黑白相间");
        cl.info();
    }

    public static void main(String[] args) {
        Cow co = new Cow(378.9);
        co.test();
    }
}