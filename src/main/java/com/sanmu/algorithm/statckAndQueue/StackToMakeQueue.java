package com.sanmu.algorithm.statckAndQueue;

import org.apache.commons.collections.CollectionUtils;

import java.util.Stack;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-08-01 10:16
 **/
public class StackToMakeQueue {
    public static void main(String[] args) {

    }


    private static class Queue<T>{
        private final Stack<T> stack1 = new Stack<T>();
        private final Stack<T> stack2 = new Stack<T>();

        public boolean add(T t){
            while(CollectionUtils.isNotEmpty(stack2)){
                stack1.push(stack2.pop());
            }
            return stack1.add(t);
        }

        public boolean offer(T t){
            return add(t);
        }

        public T remove(){
            while(CollectionUtils.isNotEmpty(stack1)){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }

        public T poll(){
            while(CollectionUtils.isNotEmpty(stack1)){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }

        public T element(){
            while(CollectionUtils.isNotEmpty(stack1)){
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }

        public T peek(){
            while(CollectionUtils.isNotEmpty(stack1)){
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }


    }
}
