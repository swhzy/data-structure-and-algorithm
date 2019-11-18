package com.swh.data.recursion;

import java.util.Arrays;

public class Permutations {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        count2();
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }
    private static void count2(){
        int[] num=new int []{1,2,3,4};
        for(int i=1;i<Math.pow(4, 4);i++){
            String str=Integer.toString(i,4);
            int sz=str.length();
            for(int j=0;j<4-sz;j++){
                str="0"+str;
            }
            char[] temp=str.toCharArray();
            Arrays.sort(temp);
            String gl=new String(temp);
            if(!gl.equals("0123")){
                continue;
            }
            String result="";
            for(int m=0;m<str.length();m++){
                result+=num[Integer.parseInt(str.charAt(m)+"")];
            }
            System.out.println(result);
        }
    }
    public static void count1(){
        int[] num=new int []{1,2,3,4,5,6,7,8,9};
        int[] ss=new int []{0,1,2,3,4,5,6,7,8};
        int[] temp=new int[9];
        while(temp[0]<9){
            temp[temp.length-1]++;
            for(int i=temp.length-1;i>0;i--){
                if(temp[i]==9){
                    temp[i]=0;
                    temp[i-1]++;
                }
            }
            int []tt=temp.clone();
            Arrays.sort(tt);
            if(!Arrays.equals(tt,ss)){
                continue;
            }
            String result="";
            for(int i=0;i<num.length;i++){
                result+=num[temp[i]];
            }
            System.out.println(result);

        }
    }
}
