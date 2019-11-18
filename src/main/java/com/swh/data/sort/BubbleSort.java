package com.swh.data.sort;

import java.util.ArrayList;
import java.util.List;


/**
 *  思路:  两个相邻的元素比较大小  进行交换
 *  当比较一轮后没有交换的操作或者全部交换一遍后结束
 *
 */
public class BubbleSort {
     static int count = 0;
    static ArrayList<Integer> integers = new ArrayList<>();
    public static void main(String[] args) {

        for (int i = 0; i < 80000; i++) {
            integers.add((int) (Math.random()*80000000));
        }

        long l = System.currentTimeMillis();

        sort(integers);

        long l1 = System.currentTimeMillis();

        System.out.println(l1-l);
        /*integers.add(3);
        integers.add(9);
        integers.add(-1);
        integers.add(10);
        integers.add(20);
        sort(integers);

        System.out.println(count);*/
    }

    public static void sort(List<Integer> arrays){

        for(int i=0;i<arrays.size();i++){
            boolean f = true;
            for (int j=1;j<arrays.size()-i;j++){
                if(arrays.get(j)<arrays.get(j-1)){
                    int a = arrays.get(j);
                    arrays.set(j,arrays.get(j-1));
                    arrays.set(j-1,a);

                    f =false;
                }
                count++;
            }
            //System.out.println(JSON.toJSONString(integers));
           if(f)break;
        }


    }
}
