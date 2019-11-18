package com.swh.data.sort;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;


public class QuickSort {


    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(-9);
        integers.add(78);
        integers.add(0);
        integers.add(78);
        integers.add(781);
        integers.add(23);
        integers.add(-567);
        integers.add(-70);

        quickSort(integers,0,integers.size()-1);

        System.out.println(JSON.toJSONString(integers));

    }


    public static void quickSort(List<Integer> arr,int left,int right){
        int l = left;
        int r = right;
        Integer pivot = arr.get((l + r) / 2);
        Integer temp;
        while (l<r){
            while (arr.get(l)<pivot){
                l+=1;
            }
            while (arr.get(r)>pivot){
                r-=1;
            }
            if(l>=r)break;
            temp = arr.get(l);
            arr.set(l,arr.get(r));
            arr.set(r,temp);
            if(arr.get(l)==pivot){
                r -=1;
            }
            if(arr.get(r)==pivot){
                l +=1;
            }

        }
        if(l==r){
            l++;
            r--;
        }
        //  向左递归排序
        if(left<r){
            quickSort(arr,left,r);
        }
        // 向右递归
        if(right>l){
            quickSort(arr,l,right);
        }





    }


}
