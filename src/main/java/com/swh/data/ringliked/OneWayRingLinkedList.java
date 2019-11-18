package com.swh.data.ringliked;

/**
 * 单向环形链表
 */

public class OneWayRingLinkedList {

    public static void main(String[] args) {
        OneWayRingLinked oneWayRingLinked = new OneWayRingLinked();
        oneWayRingLinked.addNode(1, "1");
        oneWayRingLinked.addNode(2, "2");
        oneWayRingLinked.addNode(3, "3");
        oneWayRingLinked.addNode(4, "4");
        oneWayRingLinked.addNode(5, "5");

        oneWayRingLinked.showJoseph(3, 2);

    }


    static class OneWayRingLinked {

        private Node node;


        public void addNode(int no, String text) {
            Node addNode = new Node(no, text);
            if (this.node == null) {
                this.node = addNode;
                this.node.next = this.node;
                return;
            }

            Node temp = this.node;

            while (true) {
                if (temp.next == this.node) {
                    temp.next = addNode;
                    addNode.next = node;
                    return;
                } else {
                    temp = temp.next;
                }
            }
        }

        // k 表示 第k个开始数数  m 表示数到第m个进行淘汰
        public void showJoseph(int k, int m) {

            if (node == null) {
                System.out.println("链表为空");
                return;
            }
            Node temp = node;
            int i = 1;
            int j = 1;

            while (true) {
                if (i == k) {
                    if (j == m) {
                        if (temp == temp.next) {
                            System.out.println("胜出者为:" + temp.toString());
                            return;
                        }
                        System.out.println("出局者为:" + temp.next.toString());
                        temp.next = temp.next.next;
                        j = 1;
                    } else {
                        temp = temp.next;
                        j++;
                    }

                } else {
                    i++;
                    temp = temp.next;
                }

            }


        }


    }


    static class Node {

        private int no;

        private String text;
        //双向链表的上一个元素
        private Node next;


        public Node(int no, String text) {
            this.no = no;
            this.text = text;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", text='" + text + '\'' +
                    '}';
        }
    }


}
