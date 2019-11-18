package com.swh.data.sort;

import java.util.ArrayList;
import java.util.List;

/**
 *  插入排序基本思路:
 *      把n个待排序的元素看成为一个有序表和一个无序表
 *      开始时有序表中只包含一个元素，无序表中包含n-1个元素
 *      然后从无序表中获取第一个元素，放入有序表中合适的位置
 *      直到最后一个排序完成
 */
public class InsertSort {

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        /*integers.add(3);
        integers.add(9);
        integers.add(8);
        integers.add(-1);
        integers.add(20);
        integers.add(10);

        insertSort(integers);

        System.out.println(JSON.toJSONString(integers));
*/
        for (int i = 0; i < 80000; i++) {
            integers.add((int) (Math.random()*80000000));
        }

        long l = System.currentTimeMillis();

        insertSort(integers);

        long l1 = System.currentTimeMillis();

        System.out.println(l1-l);

        //System.out.println(JSON.toJSONString(integers));

    }

    public static void insertSort(List<Integer> arg) {

        /*for (int i = 0; i < arg.size(); i++) {
            Integer currentNum = arg.get(i);
            Integer insertIndex = i -1;
            while (insertIndex>=0&&currentNum<arg.get(insertIndex)){
                arg.set(insertIndex+1,arg.get(insertIndex));
                insertIndex--;
            }
            arg.set(insertIndex+1,currentNum);

        }*/


        for (int i = 0; i < arg.size(); i++) {

            for (int j = i; j > 0; j--) {
                Integer num = arg.get(j);
                if (num < arg.get(j-1)) {
                    arg.set(j,arg.get(j-1));
                    arg.set(j-1,num);
                }else {
                    break;
                }
            }

        }
    }
}