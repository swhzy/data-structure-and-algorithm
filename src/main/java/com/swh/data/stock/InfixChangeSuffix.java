package com.swh.data.stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * 中缀表达式转换成后缀表达式(逆波兰表达式)
 * 1) 初始化两个栈：运算符栈s1和储存中间结果的栈s2；
 * 2) 从左至右扫描中缀表达式；
 * 3) 遇到操作数时，将其压s2；
 * 4) 遇到运算符时，比较其与s1栈顶运算符的优先级：
 * 1.如果s1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
 * 2.否则，若优先级比栈顶运算符的高，也将运算符压入s1；
 * 3.否则，将s1栈顶的运算符弹出并压入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较；
 * 5) 遇到括号时：  (1) 如果是左括号“(”，则直接压入s1 (2) 如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
 * 6) 重复步骤2至5，直到表达式的最右边
 * 7) 将s1中剩余的运算符依次弹出并压入s2
 * 8)  依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
 *
 *
 */
public class InfixChangeSuffix {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();

        strings.add("(");
        strings.add("3");
        strings.add("+");
        strings.add("4");
        strings.add(")");
        strings.add("*");
        strings.add("5");
        strings.add("-");
        strings.add("6");

        String change = change(strings);


    }


    public static String change(List<String> infixList){
        Stack<String> stock1 = new Stack();
        Stack<String> stock2 = new Stack();

        for (String s : infixList) {
            if(Pattern.compile("^[0-9]*$").matcher(s).matches()){ // 如果是数字则直接入 stock2栈
                stock2.push(s);
            }else if("(".equals(s)){
                stock1.push(s);
            }else if(")".equals(s)) {
                String pop = stock1.pop();
                while (!"(".equals(pop)){
                    stock2.push(pop);
                    pop = stock1.pop();
                }
            }else {

                while (!stock1.isEmpty()&&isOper(stock1.peek())&&getPriority(s)<=getPriority(stock1.peek())){
                    stock2.push(stock1.pop());
                }
                stock1.push(s);
                /*if(stock1.isEmpty()||"(".equals(stock1.peek())){ // 如果是运算符 且stock1中的栈为空则直接入stock1栈
                    stock1.push(s);
                }else if(getPriority(s)>getPriority(stock1.peek())){
                    stock1.push(s);
                }else {

                }*/
            }

        }

        while (!stock1.isEmpty()){
            stock2.push(stock1.pop());
        }

        while (!stock2.isEmpty()){
            System.out.print(" "+stock2.pop());
        }
        return null;


    }

    public static boolean isOper(String oper){
        return "+".equals(oper)||"-".equals(oper)||"*".equals(oper)||"/".equals(oper);
    }

    public static int getPriority(String oper){
        if("*".equals(oper)||"/".equals(oper)){
            return 1;
        }else if("+".equals(oper)||"-".equals(oper)){
            return 0;
        }else {
            System.out.println(
                    "操作符格式不正确"+oper
            );
            throw new RuntimeException("操作符格式不正确"+oper);
        }

    }

}

