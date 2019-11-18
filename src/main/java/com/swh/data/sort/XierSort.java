package com.swh.data.sort;

import java.util.ArrayList;
import java.util.List;

public class XierSort {

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
       /* integers.add(8);
        integers.add(9);
        integers.add(1);
        integers.add(7);
        integers.add(2);
        integers.add(3);
        integers.add(5);
        integers.add(4);
        integers.add(6);
        integers.add(0);*/

        for (int i = 0; i < 80000; i++) {
            integers.add((int) (Math.random()*80000000));
        }

        long l = System.currentTimeMillis();

        xier(integers);

        long l1 = System.currentTimeMillis();

        System.out.println(l1-l);

    }


    public static void xier(List<Integer> arr) {


        /*for (int i = 0; i < arr.size(); i++) {
            Integer currentNum = arr.get(i);
            Integer insertIndex = i -1;
            while (insertIndex>=0&&currentNum<arr.get(insertIndex)){
                arr.set(insertIndex+1,arr.get(insertIndex));
                insertIndex--;
            }
            arr.set(insertIndex+1,currentNum);

        }
*/






        /*int index = arr.size()/2;
        for(int i =index;i>0;i/=2){
            System.out.println("=======>"+i);
            for (int j = 0; j < arr.size(); j++) {
                Integer insertNum = arr.get(j);
                Integer insertIndex = j - i;

                while (insertIndex>=0&&insertNum<arr.get(insertIndex)) {
                    arr.set(insertIndex+i,arr.get(insertIndex));
                    insertIndex = insertIndex - i;
                }
                arr.set(insertIndex+i,insertNum);
            }
            System.out.println("i="+i+" arr="+JSON.toJSONString(arr));
        }

*/


        int i = arr.size();
        while ((i = i / 2) > 0) {
            for (int j = 0; j < arr.size(); j++) {
                Integer insertNum = arr.get(j);
                Integer insertIndex = j - i;

                while (insertIndex>=0&&insertNum<arr.get(insertIndex)) {
                    arr.set(insertIndex+i,arr.get(insertIndex));
                    insertIndex = insertIndex - i;
                }
                arr.set(insertIndex+i,insertNum);
            }
        }

        /*for (int m = 0; m < arr.size(); m++) {
            Integer currentNum = arr.get(m);
            Integer insertIndex = m -1;
            while (insertIndex>=0&&currentNum<arr.get(insertIndex)){
                arr.set(insertIndex+1,arr.get(insertIndex));
                insertIndex--;
            }
            arr.set(insertIndex+1,currentNum);

        }*/


    }


}
