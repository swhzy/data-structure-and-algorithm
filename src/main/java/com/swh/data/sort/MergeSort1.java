package com.swh.data.sort;

import java.util.Arrays;

public class MergeSort1 {


    public static void main(String[] args) {
        int[] ints = {8, 4, 5, 7, 1, 3, 6, 2};

        mergeSort(ints, 0, ints.length - 1, new int[ints.length]);


        System.out.println(Arrays.toString(ints));
    }


    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            } else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }
        while (i <= mid) {//将左边剩余元素填充进temp中
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while (j <= right) {//将右序列剩余元素填充进temp中
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }
        System.out.println(Arrays.toString(temp));
        /*t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }*/
    }

}
