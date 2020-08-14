package com.study6.program_6.codesClass_6_4;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-27-11:12
 */
public class Address {
    private final String detail;
    private final String postCode;


//    public Address{
//        detail = "";
//        postCode ="";
//    }

    public Address(String detail,String postCode){
        this.detail = detail;
        this.postCode = postCode;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getDetail() {
        return detail;
    }

    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj != null && obj.getClass() == Address.class){
            Address ad = (Address)obj;

            if (this.getDetail().equals(ad.getDetail())&& this.getPostCode().equals(ad.getPostCode())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode(){
        return detail.hashCode() + postCode.hashCode() * 31;
    }
}
