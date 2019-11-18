package com.swh.data;

/**
 * 双向链表
 */

public class DoubleLinkedList {


    public static void main(String[] args) {

        DoubleLinked doubleLinked = new DoubleLinked();
        doubleLinked.addNodeForLast(1, "111");
        doubleLinked.addNodeForHead(-1, "-111");
        doubleLinked.addNodeForLast(2, "222");
        doubleLinked.showLinked();
        doubleLinked.deleteNode(1);
        doubleLinked.showLinked();
        doubleLinked.deleteNode(-1);
        doubleLinked.showLinked();
        doubleLinked.deleteNode(2);
        doubleLinked.showLinked();
        doubleLinked.deleteNode(2);
        doubleLinked.showLinked();
        doubleLinked.addNodeForLast(1, "111");
        doubleLinked.updateNode(1, "我是休息");
        doubleLinked.showLinked();
        doubleLinked.addNodeForHead(-1, "-111");
        doubleLinked.addNodeForLast(2, "222");
        doubleLinked.updateNode(2, "我是e");
        doubleLinked.showLinked();


    }


    static class DoubleLinked {
        private Node head; // 表示头结点
        private Node last; // 表示尾节点


        // 从尾结点新增
        public void addNodeForLast(int no, String text) {
            Node node = new Node(no, text);
            if (last == null) {
                head = last = node;
            } else {
                last.next = node;
                node.pre = last;
                last = node;
            }
        }


        // 从头结点新增
        public void addNodeForHead(int no, String text) {
            Node node = new Node(no, text);
            if (head == null) {
                head = last = node;
            } else {
                head.pre = node;
                node.next = head;
                head = node;
            }
        }


        //删除链表中的节点
        public void deleteNode(int no) {
            if (head == null) {
                System.out.println("删除链表失败:链表为空");
                return;
            }
            Node temp = head;
            while (true) {
                if (temp == null) {
                    System.out.println("删除失败，未匹配到对应的节点");
                    return;
                }
                if (temp.getNo() == no) {

                    if (temp.getPre() == null && temp.getNext() == null) {
                        head = null;
                        last = null;
                    } else if (temp.getPre() == null) {// 说明是头结点
                        head = temp.next;
                        temp.next.pre = null;
                    } else if (temp.next == null) { // 说明是尾结点
                        temp.pre.next = null;
                        last = temp.pre;
                    } else { // 要删除的节点在中间
                        temp.pre.next = temp.next;
                        temp.next.pre = temp.pre;
                    }
                    return;
                }
                temp = temp.next;
            }
        }


        // 修改节点信息
        public void updateNode(int no, String name) {
            if (head == null) {
                System.out.println("修改节点失败:链表为空");
                return;
            }

            Node temp = head;

            while (temp != null) {

                if (temp.no == no) {
                    temp.text = name;
                    return;
                }
                temp = temp.next;
            }

            System.out.println("修改失败：未查询到节点信息");

        }


        //展示列表中的xinxi
        public void showLinked() {
            if (head == null) {
                System.out.println("展示链表失败:链表为空");
                return;
            }
            Node temp = head;
            while (true) {

                if (temp == null) return;
                System.out.println("链表数据:" + temp.toString());
                temp = temp.next;
            }
        }


    }


    static class Node {

        private int no;

        private String text;
        //双向链表的上一个元素
        private Node next;
        // 双向链表的下一个元素
        private Node pre;


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

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
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
