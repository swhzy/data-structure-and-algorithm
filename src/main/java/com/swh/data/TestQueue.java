package com.swh.data;

public class TestQueue {

    public static void main(String[] args) {

        Queue queue = Queue.createQueue(4);
        queue.pushQueue(3);
        queue.pushQueue(4);
        queue.pushQueue(5);
        queue.pushQueue(6);

        int i = queue.pullQueue();

        System.out.println(i);

        int i1 = queue.queueSize();
        System.out.println(i1);


        int i2 = queue.pullQueue();

        System.out.println(i2);

        int i3 = queue.queueSize();
        System.out.println(i3);

        int i4 = queue.pullQueue();

        int i5 = queue.pullQueue();

        int i6 = queue.queueSize();

        queue.pushQueue(8);

        int i8 = queue.queueSize();

        System.out.println(i8);

        int i7 = queue.pullQueue();

        System.out.println(i7);


    }

}
