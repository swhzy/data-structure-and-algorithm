package com.swh.data.recursion;

import com.alibaba.fastjson.JSON;

import java.util.Stack;

/**
 *
 * https://www.cnblogs.com/zzlback/p/10947064.html
 *  排列组合  回溯算法
 *
 */
public class Combination {
    public static Stack<String> stack=new Stack<String>();

    public static void main(String[] args) {
        String[] strings = {"上", "下", "左", "右"};


        ct(strings,4,0);


    }


    public static void ct(String[] direction,int targ,int cur){

        if(cur == targ){
            System.out.println(JSON.toJSONString(stack));
            return;
        }

        for (int i=0;i<direction.length;i++){
            if(!stack.contains(direction[i])) {
                stack.add(direction[i]);
                ct(direction, targ, cur + 1);
                stack.pop();
            }
        }

    }

}
