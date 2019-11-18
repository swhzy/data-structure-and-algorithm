package com.swh.data.recursion;

import com.alibaba.fastjson.JSON;

public class Queue8 {
    /**
     *  表示存放的皇后  数组元素的下标表示存放的第几个皇后也是第几行皇后
     *  数组元素中的值表示 皇后存放的第几列
     */
    int max = 8;
    private int[] arrays = new int[max];
    static int count = 0;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d种排列方法",count);
    }

    /**
     * n  表示第几个房后
     *
     * @param n
     */
    private void check(int n) {
        if (n == max) { //n == 8 表示已经开始放第九个皇后(n 从0开始)  说明前八个已经放好  也就是说当前这种放置方式已经完成
            print();
            return;
        }

        for (int i = 0; i < max; i++) {
            arrays[n] = i; // 把当前的列设置到数组中
            // 检查放入的皇后是否与其他皇后冲突
            if(!judge(n)){
                check(n+1);
            }
        }

    }

    /**
     *  n 表示第几个皇后
     *  该方法用于判断当前第n个皇后 是否与前面几个皇后有冲突
     *
     * @param n
     * @return
     */
    private boolean judge(int n) {

        for (int i=0;i<n;i++){

            /**
             * 判断第n个皇后是否跟之前的有冲突
             * arrays[i]==arrays[n] 表示是否在同一列
             * Math.abs(n-i)==Math.abs(arrays[n]-arrays[i])
             *     表示是否在同一斜线上 Math.abs(n-i)  这个表示行的差距
             *     Math.abs(arrays[n]-arrays[i]) 这个表示列的差距
             *     当行的差距跟列的差距一致时，说明在同一个斜线上
             * 至于行  因为 n表示也同时表示第几行的皇后  她与前面几行的皇后进行比较 肯定不会重复
             *
             */
            if(arrays[i]==arrays[n]||Math.abs(n-i)==Math.abs(arrays[n]-arrays[i])){
                return true;
            }


        }
        return false;
    }

    private void print() {
        count++;
        System.out.println(JSON.toJSONString(arrays));
    }


}
