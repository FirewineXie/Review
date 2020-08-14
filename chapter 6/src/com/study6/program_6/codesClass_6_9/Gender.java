package com.study6.program_6.codesClass_6_9;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-02-14:55
 */
public enum Gender {

    //此处的枚举值必须调用对象的构造器来创建
    MALE("男"),FEMALE("女");

    private final String name;

    private Gender (String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
