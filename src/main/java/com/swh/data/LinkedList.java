package com.swh.data;

import com.alibaba.fastjson.JSON;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Stack;

public class LinkedList {

    public static void main(String[] args) {
        Node node1 = new Node(23, "向喀什23");
        Node node2 = new Node(40, "向喀什40");
        Node node3 = new Node(20, "向喀什20");
        Node node4 = new Node(39, "向喀什39");


        SingleLinked singleLinked = new SingleLinked();
        singleLinked.addNode(node1);
        singleLinked.addNode(node2);
        singleLinked.addNode(node3);
        singleLinked.addNode(node4);
        singleLinked.addNode(node4);

        singleLinked.reversePrint();





        System.out.println("反转之前------------");
        singleLinked.showNode();
        singleLinked.reverse();
        System.out.println("反转之后------------");
        singleLinked.showNode();


        System.out.println("倒数K个节点-->" + singleLinked.getFromBehindKNode(2).getName());


        System.out.println("链表的元素的数量->" + singleLinked.getSize());

        singleLinked.updateNode(40, "my name is 40");
        singleLinked.delete(23);
        singleLinked.showNode();
        System.out.println("链表的元素的数量->" + singleLinked.getSize());
        singleLinked.delete(40);
        System.out.println("倒数K个节点-->" + singleLinked.getFromBehindKNode(1).getName());
        singleLinked.delete(39);
        singleLinked.delete(20);
        singleLinked.delete(20);

        singleLinked.showNode();
        System.out.println("链表的元素的数量->" + singleLinked.getSize());

    }

}

class SingleLinked {

    private Node head = new Node(0, "");

    // 添加链表
    public void addNode(Node node) {
        // 获取最后一个节点
        Node temp = head;

        while (true) {
            if (temp.getNo() == node.getNo()) {
                System.out.println("添加的节点已经存在了！！ no->" + node.getNo() + "  name->" + node.getName());
                return;
            }
            if (temp.getNext() == null) {

                temp.setNext(node);
                return;
            }

            if (temp.getNext().getNo() > node.getNo()) {
                node.setNext(temp.getNext());
                temp.setNext(node);
                return;
            }


            temp = temp.getNext();
        }
    }

    // 修改链表
    public void updateNode(int no, String name) {

        Node temp = head.getNext();

        while (true) {
            if (temp == null) {
                System.out.println("链表中无数据~");
                return;
            }
            if (temp.getNo() == no) {
                temp.setName(name);
                return;
            }

            if (temp.getNo() != no && temp.getNext() == null) {
                System.out.printf("未查询到编号为%d的数据信息\n", no);
                return;
            }
            temp = temp.getNext();

        }

    }

    //删除列表
    public void delete(int no) {

        Node temp = head;

        while (true) {
            if (temp.getNext() == null) {
                System.out.printf("未查询到编号为%d的数据信息", no);
                return;
            }
            if (temp.getNext().getNo() == no) {
                temp.setNext(temp.getNext().getNext());
                return;
            }
            temp = temp.getNext();

        }



    }


    public void showNode() {

        Node temp = head.getNext();

        while (true) {
            if (temp == null) {
                System.out.println("链表中无数据~");
                return;
            }
            System.out.println(temp.toString());

            if (temp.getNext() == null)
                return;

            temp = temp.getNext();


        }


    }


    //求链表中的个数  直接遍历链表
    public int getSize() {

        Node temp = head.getNext();
        int size = 0;
        while (true) {
            if (temp == null) {
                System.out.println("链表中无数据~");
                return size;
            }
            size++;
            temp = temp.getNext();
        }
    }


    // 查找单链表中的倒数第K个节点
    // 思路:获取总条数 然后求出正数多少个  然后进行遍历求出、

    public Node getFromBehindKNode(int k) {
        // 获取总条数
        int size = getSize();
        k = size - k -1;
        if (k <= 0||k>size) {
            System.out.println("请在链表的范围内查询");
            return null;
        }
        Node temp = head.getNext();
        int count = 0;
        while (true) {
            if (temp == null) {
                System.out.println("链表中无数据~");
                return null;
            }
            count++;

            if (count == k) return temp;
            temp = temp.getNext();
        }
    }

    public Node getFromBehindKNode1(int k) {
        // 获取总条数
        int size = getSize();
        k = size - k ;
        if (k <= 0||k>size) {
            System.out.println("请在链表的范围内查询");
            return null;
        }
        Node temp = head.getNext();

        for(int i=0;i<k;i++){
            temp = temp.getNext();
        }

        return temp;

        /*int count = 0;
        while (true) {
            if (temp == null) {
                System.out.println("链表中无数据~");
                return null;
            }
            count++;

            if (count == k) return temp;
            temp = temp.getNext();
        }*/
    }



    //单链表的反转
    //思路 : 遍历链表 把遍历到的节点迁移到第一个
    public void reverse() {

        if (head.getNext() == null) {  // 如果发现链表为空就直接返回
            System.out.println("链表为空");
            return;
        }

        Node temp = head.getNext();

        while (true) {
            Node next = null;
            // 当第一个节点是最后一个节点时就不需要进行移动了
            if ((next = temp.getNext()) == null) return;
            // 1.把当前节点的指针指向下下一个节点
            temp.setNext(next.getNext());
            // 2.将获取到的节点设置成第一个节点
            next.setNext(head.getNext());
            head.setNext(next);
        }

    }
    //逆序打印

    public void reversePrint() {
        Node temp = head.getNext();
        if (temp == null) {
            System.out.println("链表为空");
            return;
        }
        ArrayDeque<Node> stack = new ArrayDeque<>();

        while (true) {
            if (temp == null) break;

            stack.add(temp);
            temp = temp.getNext();
        }

        Iterator<Node> nodeIterator = stack.descendingIterator();
        while (nodeIterator.hasNext()){
            System.out.println("链表中的信息->"+JSON.toJSONString(nodeIterator.next().getNo()));
        }

    }

    public void reversePrint1() {
        Node temp = head.getNext();
        if (temp == null) {
            System.out.println("链表为空");
            return;
        }
        Stack<Node> stack = new Stack();

        while (true) {
            if (temp == null) break;

            stack.push(temp);
            temp = temp.getNext();
        }


        while (stack.size()>0){
            System.out.println("链表中的信息->"+JSON.toJSONString(stack.pop().getNext().getNo()));
        }

    }





    // 合并两个有序列表
    // 思路：  上面插入链表数据的时候已经有了排序方法直接把一个有序的列表插入到另一个有序列表中就可以了
    public SingleLinked mergeTwoOrderLinked(SingleLinked one, SingleLinked two){
        Node temp = one.head.getNext();
        if(temp==null)return two;

        while (true){
            if(temp==null)break;
            two.addNode(temp);
            temp = temp.getNext();
        }

        return two;
    }


}


class Node {

    private int no;

    private String name;

    private Node next;


    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", name='" + name + '\'' +
                '}';
    }
}