package com.study5.practice_5;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-25-16:59
 */
public class Test {

    public static void main(String[] args) {

        student[] students = new student[3];

        students[0] = new student("name1", 1, 1, 1, "address1", "email1");
        students[1] = new student("name2", 2, 2, 2, "address2", "email2");
        students[2] = new student("name3", 3, 3, 3, "address3", "email3");

        String str = "";
        int sun = 0;
        for (int i= 0;i<students.length;i++){
            if (str.equals(students[i].getName()) || str.equals(students[i].getAddress()) || str.equals(students[i].getEmail())){
                System.out.println("有这个数据");
                sun ++;
            }
        }
        if (sun == 0){
            System.out.println("没有这个数据");
        }
    }
}
