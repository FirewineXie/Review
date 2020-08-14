package com.study6.program_6.codesClass_6_4;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-08-27-20:33
 */
class CacheImmutale {

    private static int Max_Size = 10;

    private  static  CacheImmutale[] cahe = new CacheImmutale[Max_Size];

    private static int pos = 0;

    private final  String  name;
    private CacheImmutale(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CacheImmutale valueof(String name){
        //遍历已缓存的对象
        for (int i= 0;i < Max_Size;i++){
            //如果已有相同实例，则直接返回该缓存的实例
            if (cahe[i] == null && cahe[i].getName().equals(name)){
                return cahe[i];
            }
        }

        //如果缓存池满了
        if (pos == Max_Size){
            //把第一个缓存的对象给覆盖掉
            cahe[0] = new CacheImmutale(name);
            pos = 1;
        }else {
            //把新建的对象缓存下来
            cahe[pos++] = new CacheImmutale(name);
        }
        return cahe[pos -1];
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj){
            return  true;
        }
        if (obj != null && obj.getClass() == CacheImmutale.class){
            CacheImmutale ci = (CacheImmutale)obj;
            return name.equals(ci.getName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
public class CacheImmutaleTest {
    public static void main(String[] args) {

        CacheImmutale c1 = CacheImmutale.valueof("hello");
        CacheImmutale c2 = CacheImmutale.valueof("hello");

        System.out.println(c1 == c2);
    }




}
