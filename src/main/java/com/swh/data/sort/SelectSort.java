package com.swh.data.sort;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 *  思路: 选择一个最小或者最大的数放置在前面排完序的最后一个位置
 *
 */
public class SelectSort {

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(3);
        integers.add(9);
        integers.add(9);
        integers.add(-1);
        integers.add(10);
        integers.add(20);
        select(integers);
        System.out.println(JSON.toJSONString(integers));
    }

    public static void select(List<Integer> arrays) {

        for (int i = 0; i < arrays.size(); i++) {
            int num = arrays.get(i);
            int index = i;
            for (int j = i; j < arrays.size(); j++) {
                if(num>arrays.get(j)){
                    num = arrays.get(j);
                    index = j;
                }
            }
            if(index!=i) {
                arrays.set(index, arrays.get(i));
                arrays.set(i, num);
            }
        }


    }
}
