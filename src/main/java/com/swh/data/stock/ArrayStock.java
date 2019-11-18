package com.swh.data.stock;

public class ArrayStock {
    public static void main(String[] args) {

        Stock stock = new Stock(5);
        stock.push(1);
        stock.push(2);
        stock.push(3);
        stock.push(5);
        stock.push(6);
        stock.push(4);
        System.out.println(stock.pop());
        System.out.println(stock.pop());
        System.out.println(stock.pop());
        stock.show();


    }
}


class Stock{

    private int[] arr;

    private int stackFrameBottom = -1; // 栈底的指针

    private int stackFrameTop = -1; //栈顶的指针

    public Stock(int size) {
        this.arr = new int[size];
    }


    public void push(int data){

        stackFrameTop++;

        if(stackFrameTop>arr.length-1){
            stackFrameTop--;
            System.out.println("栈已满，无法进行入栈");
            return;
        }
        arr[stackFrameTop] = data;
    }

    public int pop(){
        if(stackFrameTop==stackFrameBottom){
            System.out.println("栈已空，无法进行出栈");return -1;
        }
        int res=arr[stackFrameTop];
        arr[stackFrameTop] = 0 ;
        stackFrameTop--;
        return res;
    }


    public void show(){
        if(stackFrameTop==stackFrameBottom){
            System.out.println("栈已空，无法进行出栈");return;
        }
        for(int i=0;i<=stackFrameTop;i++){
            System.out.println("栈中的信息:"+arr[i]);
        }


    }






}
