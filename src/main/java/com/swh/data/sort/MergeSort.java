package com.swh.data.sort;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 归并排序 分而治之
 */
public class MergeSort {


    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();

        integers.add(8);
        integers.add(4);
        integers.add(5);
        integers.add(7);
        integers.add(1);
        integers.add(3);
        integers.add(6);
        integers.add(2);


        mergeSort(integers,0,integers.size()-1,new ArrayList<Integer>());

       // System.out.println(JSON.toJSONString(integers));

    }

    public static void mergeSort(List<Integer> arr,int left,int right,List<Integer> temp){
        if(left<right){
            int mid = (left+right)/2;
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);

        }
    }





    public static void merge(List<Integer> arr,int left,int mid,int right,List<Integer> temp) {

        int i = left;
        int j = mid+1;

        while (i<=mid&&j<=right){

            if(arr.get(i)<=arr.get(j)){
                temp.add(arr.get(i));
                i++;
            }else {
                temp.add(arr.get(j));
                j++;
            }
        }
        while (i<=mid){
            temp.add(arr.get(i));
            i++;
        }
        while (j<=right){
            temp.add(arr.get(j));
            j++;
        }

System.out.println(JSON.toJSONString(temp));
        int t =0;
        int tempLeft = left;
        while (tempLeft<=right){
            arr.set(tempLeft,temp.get(t));
            t+=1;
            tempLeft+=1;
        }
        //System.out.println(JSON.toJSONString(temp));
        temp.clear();


    }


}
