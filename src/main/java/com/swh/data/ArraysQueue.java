package com.swh.data;

import com.alibaba.fastjson.JSON;

public class ArraysQueue {

    public static void main(String[] args) {



        Queue1 queue = new Queue1(3);

        queue.addQueue(10);


        System.out.println(queue.getHeadQueue());
        System.out.println(queue.getSize());
        System.out.println(queue.isEmpty());
        System.out.println(queue.isfull());
        System.out.println(JSON.toJSONString(queue.showQueues()));
        System.out.println("--------------->"+queue.getQueue());

        //System.out.println(queue.getHeadQueue());
        System.out.println(queue.getSize());
        //System.out.println(queue.isEmpty());
        System.out.println(queue.isfull());
        //System.out.println(JSON.toJSONString(queue.showQueues()));

        queue.addQueue(20);


        System.out.println(queue.getHeadQueue());
        System.out.println(queue.getSize());
        System.out.println(queue.isEmpty());
        System.out.println(queue.isfull());
        System.out.println(JSON.toJSONString(queue.showQueues()));
        System.out.println("--------------->"+queue.getQueue());

        queue.addQueue(30);
        queue.addQueue(40);
        System.out.println(queue.getHeadQueue());
        System.out.println(queue.getSize());
        System.out.println(queue.isEmpty());
        System.out.println(queue.isfull());
        System.out.println(JSON.toJSONString(queue.showQueues()));


        /*queue.addQueue(20);
        queue.addQueue(30);

        System.out.println(queue.getQueue());
        System.out.println(JSON.toJSONString(queue.showQueues()));
        System.out.println(queue.getQueue());
        System.out.println(JSON.toJSONString(queue.showQueues()));
        System.out.println(queue.getQueue());
        System.out.println(JSON.toJSONString(queue.showQueues()));

        queue.addQueue(40);
        System.out.println(queue.getHeadQueue());
        System.out.println(JSON.toJSONString(queue.showQueues()));
        System.out.println(queue.getHeadQueue());
        System.out.println(JSON.toJSONString(queue.showQueues()));*/
    }


}

class Queue1 {
    private int queueSize;
    private int headPointer;
    private int tailPointer;
    private int[] arr;

    public Queue1(int queueSize) {
        this.queueSize = queueSize;
        headPointer = -1;
        tailPointer = -1;
        arr = new int[queueSize];
    }

    public boolean isfull() {
        return headPointer - tailPointer >= queueSize;
    }

    public boolean isEmpty() {
        return headPointer == tailPointer;
    }


    public void addQueue(int num) {
        if (isfull()) System.out.println("队列满了，不能再插入数据");
        headPointer++;
        headPointer = headPointer % queueSize;

        arr[headPointer] = num;
    }

    public int getQueue() {
        if (isEmpty()) throw new RuntimeException("队列空了，不能再取数据");
        tailPointer++;
        tailPointer = tailPointer % queueSize;
        int tail = arr[tailPointer];
        arr[tailPointer] = 0;
        return tail;
    }

    public int getHeadQueue() {
        if (isEmpty()) throw new RuntimeException("队列空了，没有头数据");
        return arr[headPointer];
    }

    public int[] showQueues() {
        if (isEmpty()) throw new RuntimeException("队列空了，没有队列数据");

        for(int i=tailPointer+1;i<=tailPointer+getSize();i++){
            System.out.printf("队列中的数据:arr[%d]=%d\n",i%queueSize,arr[i%queueSize]);
        }



        return arr;
    }

    public int getSize() {

        return (queueSize+headPointer-tailPointer)%queueSize;
        //  下面所注释的代码可以合并成上面一句代码


       /* if(headPointer>=tailPointer){
            return headPointer-tailPointer;
        }else {
            //这个是指tailPointer指针大于headPointer指针时
            // 获取队列长度应该是  (queueSize-tailPointer-1)+(headPointer+1)
            return queueSize+headPointer-tailPointer;
        }*/
    }


}