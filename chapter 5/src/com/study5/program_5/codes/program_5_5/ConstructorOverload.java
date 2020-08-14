package com.study5.program_5.codes.program_5_5;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-22-15:44
 */
public class ConstructorOverload {

    public String name;
    public int count;
    public double weight;
    //提供无参构造器
    public ConstructorOverload(){ }

    //提供两个参数的构造器，
    //对该该构造器返回的对象进行初始化
    public ConstructorOverload (String name ,int count){
        this.name = name;
        this.count = count;

    }
    public ConstructorOverload(String name ,int count ,double weight){
        //通过this调用另一个重载的构造器的初始化代码
        this(name,count);
        this.weight = weight;
    }

    /*
          系统会根据参数的数量来决定调用那个构造器

          但是当出现构造器b完全包含构造器a 对于这种情况就使用this，，，（如果在方法再new一个对象，会浪费内存）

     */
    public static void main(String[] args) {

        //通过无参构造器创建对象
        ConstructorOverload constructorOverload = new ConstructorOverload();

        //通过有参构造器创建对象
        ConstructorOverload constructorOverload1 = new ConstructorOverload("年后",3000);

        System.out.println(constructorOverload.name+"  " + constructorOverload.count);
        System.out.println(constructorOverload1.name +"  "+ constructorOverload1.count);
    }
}
