package com.swh.data;

import com.alibaba.fastjson.JSON;

/**
 *  按照自己失败的思路
 *
 *
 *
 */



public class TwoWayLinkedList {
    public static void main(String[] args) {

        TwoWayLinked twoWayLinked = new TwoWayLinked();

        TwoWayNode twoWayNode = new TwoWayNode(1, "百家排行榜第一位");

        twoWayLinked.addNodeByNext(twoWayNode);


        TwoWayNode twoWayNodeTwo = new TwoWayNode(2, "百家排行榜第二位");

        twoWayLinked.addNodeByHead(twoWayNodeTwo);


        TwoWayNode twoWayNodeThree = new TwoWayNode(3, "百家排行榜第三位");

        twoWayLinked.addNodeByNext(twoWayNodeThree);


        TwoWayNode twoWayNodeFour = new TwoWayNode(4, "百家排行榜第四位");

        twoWayLinked.addNodeByHead(twoWayNodeFour);


        twoWayLinked.updateNode(new TwoWayNode(1, "dsf"));


        twoWayLinked.updateNode(new TwoWayNode(4, "444444444444444"));


        System.out.println(JSON.toJSONString(twoWayLinked));

        twoWayLinked.deleteNode(new TwoWayNode(3,"dsfsd"));

        System.out.println(JSON.toJSONString(twoWayLinked));

        twoWayLinked.deleteNode(new TwoWayNode(1,"dsfsd"));

        System.out.println(JSON.toJSONString(twoWayLinked));

        twoWayLinked.deleteNode(new TwoWayNode(4,"dsfsd"));

        System.out.println(JSON.toJSONString(twoWayLinked));


        twoWayLinked.deleteNode(new TwoWayNode(2,"dsfsd"));

        System.out.println(JSON.toJSONString(twoWayLinked));


    }

}

class TwoWayLinked {
    private TwoWayNode node;


    // 新增一个节点 从节点后方添加
    public void addNodeByNext(TwoWayNode twoWayNode) {
        if (node == null) {
            node = twoWayNode;
            return;
        }

        TwoWayNode temp = node;


        while (true) {
            if (temp.getNext() == null) {
                temp.setNext(twoWayNode);
                twoWayNode.setBefore(temp);
                return;
            }
            temp = temp.getNext();
        }
    }


    // 新增一个节点  从链表前端添加
    public void addNodeByHead(TwoWayNode twoWayNode) {
        if (node == null) {
            node = twoWayNode;
            return;
        }
        TwoWayNode temp = node;

        while (true) {
            if (temp.getBefore() == null) {
                temp.setBefore(twoWayNode);
                twoWayNode.setNext(temp);
                return;
            }
            temp = temp.getBefore();
        }

    }


    // 修改双向链表
    // 思路:先网上找 再往下找
    public void updateNode(TwoWayNode twoWayNode) {

        if (node == null) {
            System.out.println("修改链表失败:链表为空");
            return;
        }

        TwoWayNode temp = node;

        while (true) {
            if (temp == null) break;
            if (temp.getNo() == twoWayNode.getNo()) {
                temp.setName(twoWayNode.getName());
                return;
            }
            temp = temp.getNext();
        }


        temp = node.getBefore();
        while (true) {
            if (temp == null) break;
            if (temp.getNo() == twoWayNode.getNo()) {
                temp.setName(twoWayNode.getName());
                return;
            }
            temp = temp.getBefore();
        }

        System.out.println("更新失败:未查询到对应的更新数据");


    }


    public void deleteNode(TwoWayNode twoWayNode) {
        if (node == null) {
            System.out.println("删除链表失败:链表为空");
            return;
        }

        TwoWayNode temp = node;

        while (true) {
            if (temp == null) break;
            if (temp.getNo() == twoWayNode.getNo()) {
                temp.getBefore().setNext(temp.getNext());
                if (temp.getNext() != null)
                    temp.getNext().setBefore(temp.getBefore());
                return;
            }
            temp = temp.getNext();
        }


        temp = node.getBefore();
        while (true) {
            if (temp == null) break;
            if (temp.getNo() == twoWayNode.getNo()) {
                if (temp.getBefore() != null)
                    temp.getBefore().setNext(temp.getNext());
                temp.getNext().setBefore(temp.getBefore());
                return;
            }
            temp = temp.getBefore();
        }

        System.out.println("删除失败:未查询到该节点");


    }


    public TwoWayNode getNode() {
        return node;
    }

    public void setNode(TwoWayNode node) {
        this.node = node;
    }
}


class TwoWayNode {

    // 存储的编号
    private int no;
    //存储的名字
    private String name;
    //下一个节点
    private TwoWayNode next;
    //上一个节点
    private TwoWayNode before;


    public TwoWayNode(int no, String name) {
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

    public TwoWayNode getNext() {
        return next;
    }

    public void setNext(TwoWayNode next) {
        this.next = next;
    }

    public TwoWayNode getBefore() {
        return before;
    }

    public void setBefore(TwoWayNode before) {
        this.before = before;
    }
}