package com.swh.data.stock;

public class LinkedStockDemo {

    public static void main(String[] args) {
        LinkedStock stock = new LinkedStock();
        stock.push(2);
        stock.push(3);
        stock.push(4);
        stock.push(5);
        stock.push(2);

        /*stock.pop();
        stock.pop();
        stock.pop();
        stock.pop();
        stock.pop();
        stock.pop();*/

        stock.show();


    }

}

class LinkedStock {

    private StockNode headNode;

    private StockNode lastNode; // 最后一个节点

    public Boolean isEmtry() {
        return headNode == null;
    }

    //入栈
    public void push(int no) {
        StockNode stockNode = new StockNode(no);
        if (isEmtry()) {
            headNode=lastNode = stockNode;
            return;
        }
        lastNode.setNext(stockNode);
        stockNode.setPre(lastNode);
        lastNode=stockNode;
    }

    public int pop(){
        if(isEmtry()){
            throw new RuntimeException("链表为空，无法出栈");
        }
        int no = lastNode.getNo();
        lastNode.getPre().setNext(null);
        lastNode = lastNode.getPre();
        System.out.println("出栈的数据:"+no);
        return no;
    }


    public void show(){
        System.out.println("从栈顶到栈底的数据依次为:");
        StockNode temp = lastNode;
        while (temp!=null){
            System.out.println(temp.getNo());
            temp = temp.getPre();
        }
    }

}

class StockNode {
    private int no;

    private StockNode next;
    private StockNode pre;

    public StockNode(int no) {
        this.no = no;
    }

    public StockNode getPre() {
        return pre;
    }

    public void setPre(StockNode pre) {
        this.pre = pre;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public StockNode getNext() {
        return next;
    }

    public void setNext(StockNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "StockNode{" +
                "no=" + no +
                '}';
    }
}