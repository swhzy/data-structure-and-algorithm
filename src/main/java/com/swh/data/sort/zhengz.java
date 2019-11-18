package com.swh.data.sort;

import java.util.regex.Pattern;

public class zhengz {

    public static void main(String[] args) {

        System.out.println(isHave1("sd@fasd"));



    }


    /**
     * ^!@#$%^&*（）
     * @param inputStr
     * @param specialStr
     * @return
     */


    public static  boolean isHave(String inputStr,String specialStr){
        for (int i=0;i<specialStr.length();i++){
            String substring = specialStr.substring(i, i + 1);
            if(inputStr.contains(substring))return true;
        }
        return false;
    }


















    /**
     *  判断 sourceStr 字符串是否包含特殊字符
     *   如果包含 返回true
     *   如果不包含 返回 false
     *
     * @param sourceStr
     * @return
     */

    public static  boolean isHave1(String sourceStr){
        String pt = "[!@#$%^&*（）]*";
        return Pattern.matches(pt, sourceStr);

    }
}
