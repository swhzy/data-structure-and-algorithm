package com.swh.data.stock;

public class PrefixCalculator {


    public static void main(String[] args) {

        PrefixCalculatorStock prefixCalculatorStock = new PrefixCalculatorStock();

        int i = prefixCalculatorStock.doCaculator("20*80/10");

        System.out.println(i);

        // System.out.println('3'-'0');


    }


}

class PrefixCalculatorStock {

    private int[] arr;

    private int stackFrameBottom = -1; // 栈底的指针

    private int stackFrameTop = -1; //栈顶的指针

    public PrefixCalculatorStock(int size) {
        this.arr = new int[size];
    }

    public PrefixCalculatorStock() {
    }

    public void push(int data) {

        stackFrameTop++;

        if (stackFrameTop > arr.length - 1) {
            stackFrameTop--;
            System.out.println("栈已满，无法进行入栈");
            return;
        }
        arr[stackFrameTop] = data;
    }

    public boolean isEmpty() {
        return stackFrameTop == -1;
    }

    public int pop() {
        if (stackFrameTop == stackFrameBottom) {
            System.out.println("栈已空，无法进行出栈");
            return -1;
        }
        int res = arr[stackFrameTop];
        arr[stackFrameTop] = 0;
        stackFrameTop--;
        return res;
    }


    public int peep() {
        if (isEmpty()) throw new RuntimeException("栈为空");
        return arr[stackFrameTop];
    }


    public int getPriority(char oper) {
        if ('+' == oper || '-' == oper) {
            return 0;
        } else if ('*' == oper || '/' == oper) {
            return 1;
        } else {
            throw new RuntimeException("运算符的格式不正确");
        }
    }


    public void show() {
        if (stackFrameTop == stackFrameBottom) {
            System.out.println("栈已空，无法进行出栈");
            return;
        }
        for (int i = 0; i <= stackFrameTop; i++) {
            System.out.println("栈中的信息:" + arr[i]);
        }


    }

    public int caculator(char oper, int num1, int num2) {
        switch (oper) {
            case '+':
                return num1 + num2;
            case '-':
                return num2 - num1;
            case '*':
                return num1 * num2;
            case '/':
                return num2 / num1;
            default:
                throw new RuntimeException("未查询到运算符信息");
        }
    }


    public int doCaculator(String expression) {

        PrefixCalculatorStock numberStock = new PrefixCalculatorStock(expression.length());


        PrefixCalculatorStock operStock = new PrefixCalculatorStock(expression.length());
        int i = 0;
        while (i < expression.length()) {
            char str = expression.substring(i++).charAt(0);
            if (isOper(str)) { // 如果是操作符
                if (operStock.isEmpty()) { // 如果操作符为空 则直接筛入
                    operStock.push(str);
                } else {
                    int peep = operStock.peep();
                    while (!operStock.isEmpty() && getPriority((char) peep) >= getPriority(str)) { // 如果当前操作服务的优先级小于或等于  栈顶的优先级
                        //弹出栈顶的运算符  然后弹出数栈中的两个数
                        int operPop = operStock.pop();
                        int numPop1 = numberStock.pop();
                        int numPop2 = numberStock.pop();

                        int caculator = caculator((char) operPop, numPop1, numPop2);
                        numberStock.push(caculator);
                    }
                    operStock.push(str);
                }
            } else { // 如果是一个数
                int j = i;
                String num = String.valueOf(str - '0');
                char strNext ;
                while (j < expression.length()&&!isOper(strNext=expression.substring(j++).charAt(0))){

                    num +=String.valueOf(strNext - '0');
                    i++;
                }

                numberStock.push(Integer.valueOf(num));

            }
        }

        while (!operStock.isEmpty()) {
            int caculator = caculator((char) operStock.pop(), numberStock.pop(), numberStock.pop());
            numberStock.push(caculator);
        }


        return numberStock.pop();

    }

    public boolean isOper(char index) {
        return index == '+' || index == '-' || index == '*' || index == '/';
    }


}

