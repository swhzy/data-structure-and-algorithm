package com.swh.data.search;

public class TwoPointsSearch {

    public static void main(String[] args) {
        int[] arr = {1,2,7,45,51,65,79,90};
        search(arr,0,arr.length-1,3);
    }

    public static void search(int[] arr, int left, int right, int value) {
        if(left>right){
            System.out.println("-1");
            return;
        }
        int i = (left + right) / 2;

        /*if(left+1==right){
            System.out.println("没找到"+left+"  "+right);
            return;
        }
*/
        if(value>arr[i]){
            search(arr,i+1,right,value);
        }else if(value<arr[i]){
            search(arr,left,i-1,value);
        }else {
            System.out.println("找到了"+i);
            return;
        }



    }

}
