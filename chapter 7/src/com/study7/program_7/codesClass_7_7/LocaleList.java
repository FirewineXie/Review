package com.study7.program_7.codesClass_7_7;

import java.util.Locale;

/**
 * @version : 1.0
 * @auther : xie     xyjworkgame@163.com
 * @Program Name: <br>
 * @Create : 2018-09-04-10:41
 */
public class LocaleList {

    public static void main(String[] args) {

        Locale[] locales = Locale.getAvailableLocales();

        for (int i= 0;i<locales.length;i++){
            System.out.println(locales[i].getDisplayCountry() + "=" + locales[i].getCountry()
                            + "  " + locales[i].getDisplayLanguage() + "=" + locales[i].getLanguage());
        }
    }
}
