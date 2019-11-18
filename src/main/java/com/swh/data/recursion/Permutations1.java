package com.swh.data.recursion;

import java.util.Arrays;
import java.util.Scanner;

public class Permutations1 {


    private static boolean f[];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int sz=sc.nextInt();
        for(int i=0;i<sz;i++){
            int sum=sc.nextInt();
            f=new boolean[sum];
            Arrays.fill(f, true);
            int[] num=new int[sum];
            for(int j=0;j<sum;j++){
                num[j]=j+1;
            }
            int nn=sc.nextInt();
            String str="";
            count(num,str,nn);
        }
    }
    /**
     *
     * @param num 表示要排列的数组
     * @param str 以排列好的字符串
     * @param nn  剩下需要排列的个数，如果需要全排列，则nn为数组长度
     */
    private static void count(int[] num, String str, int nn) {
        if(nn==0){
            System.out.println(str);
            return;
        }
        for(int i=0;i<num.length;i++){
            if(!f[i]){
                continue;
            }
            f[i]=false;
            count(num,str+num[i],nn-1);
            f[i]=true;
        }
    }

}
