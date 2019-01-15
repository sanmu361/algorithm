package com.sanmu.algorithm.LinkedList;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2019-01-15 11:20
 **/
public class MinStack {

    private PriorityQueue<Integer> minQueue;

    private Stack<Integer> stack;

    public MinStack(){
        stack = new Stack<Integer>();
        minQueue = new PriorityQueue<Integer>();
    }

    public void push(int x){
        stack.push(x);
        minQueue.offer(x);
    }

    public int pop(){
        Integer result = stack.pop();
        minQueue.remove(result);
        return result;
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return minQueue.peek();
    }
    public static void main(String[] args) {
        System.out.println(convertToTitle(53));
    }

    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            n--;
            int c = n % 26;
            sb.insert(0, (char) (c + 'A'));
            n = n / 26;
        }
        return sb.toString();
    }
}
