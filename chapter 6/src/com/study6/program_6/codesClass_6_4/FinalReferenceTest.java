package com.study6.program_6.codesClass_6_4;

import java.util.Arrays;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-27-10:52
 */
class Person{
    private int age;
    public Person(){};

    public Person(int age){
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
public class FinalReferenceTest {

    public static void main(String[] args) {

        final int[] iArr = {5,6,12,9};

        System.out.println(Arrays.toString(iArr));

        Arrays.sort(iArr);//进行排序
        System.out.println(Arrays.toString(iArr));

        iArr[2]  =90;

        System.out.println(Arrays.toString(iArr));
        //这样就是错误的，
        //iArr = null;

        final Person person = new Person(45);

        person.setAge(46);

        System.out.println(person.getAge());
        //不合法的
        //p = null;


        /*
            从上面看出，final修饰的引用类型变量不能被重新赋值，但可以改变引用类型变量所引用对象的内容
         */
    }
}
