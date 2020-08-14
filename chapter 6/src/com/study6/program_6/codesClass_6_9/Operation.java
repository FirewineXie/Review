package com.study6.program_6.codesClass_6_9;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-02-14:59
 */
public enum  Operation {
    PLUS{
        public double eval(double x,double y){
            return x+y;
        }
    },
    MINUS{
        public double eval(double x,double y){
            return x -y;
        }
    },
    TIMES{
        public double eval(double x,double y){
            return x * y;
        }
    },
    DIVIDE{
        public double eval(double x,double y){
            return x / y;
        }
    };



    public abstract double eval(double x,double y);

    public static void main(String[] args) {
        System.out.println(Operation.MINUS.eval(3,4));
    }

}
