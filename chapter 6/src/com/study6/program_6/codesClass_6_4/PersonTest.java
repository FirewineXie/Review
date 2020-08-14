package com.study6.program_6.codesClass_6_4;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-27-20:17
 */
class Name{
    private String fistName;
    private String lastName;

    public Name(){}
    public Name(String fistName,String lastName){
        this.fistName = fistName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }
}
public class PersonTest{
       private final Name name;
//    public PersonTest(Name name){
//        this.name = name;
//    }
//    public Name getName(){
//        return name;
//    }
    //应该设计成name实例变量为临时创建的Name对象，
    public PersonTest(Name name){
        this.name = new Name(name.getFistName(),name.getLastName());
    }
    public Name getName(){
        return new Name(name.getFistName(),name.getLastName());
    }

    public static void main(String[] args) {

        Name n = new Name("悟空","孙");

        PersonTest p = new PersonTest(n);

        System.out.println(p.getName().getFistName());
        //这样能够改变对象的值，会造成破坏设计类的初衷
        n.setFistName("八戒");

        System.out.println(p.getName().getFistName());
    }
}
