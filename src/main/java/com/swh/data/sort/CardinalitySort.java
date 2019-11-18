package com.swh.data.sort;

/**
 *  基数排序
 */
public class CardinalitySort {

    public static void main(String[] args) {

        int[] aa = {1,234,23,98,534,733,832};
        int n = 10;
        for(int i=0;i<aa.length;i++) {
            int[][] ints = new int[10][aa.length];

            String sub = String.valueOf(aa[i]).substring(i);
            System.out.println(sub);

            n*=10;

        }



    }

}
