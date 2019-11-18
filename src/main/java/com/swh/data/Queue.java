package com.swh.data;

public class Queue {
    private int[] queueTopic;
    private int occupiedSize = 0;


    private Queue(int[] queueTopic) {
        this.queueTopic = queueTopic;
    }

    public static Queue createQueue(int size){
        int[] initQueue = new int[size];
        return new Queue(initQueue);
    }


    public void pushQueue(int num){
        if(occupiedSize>=queueTopic.length)throw new RuntimeException("队列已满");
        queueTopic[occupiedSize]=num;
        occupiedSize++;
    }



    public int pullQueue(){
        if(occupiedSize<=0)throw new RuntimeException("队列已空");
        int stratData = queueTopic[0];

        for(int i =0;i<occupiedSize;i++){
            if(i>=queueTopic.length-1)
                queueTopic[queueTopic.length-1]=0;
            else
                queueTopic[i] = queueTopic[i + 1];
        }
        occupiedSize--;
        return stratData;
    }

    public int queueSize(){
        return occupiedSize;
    }





}
