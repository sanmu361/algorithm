package com.sanmu.algorithm.statckAndQueue;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-31 9:43
 **/
public class QueueToMakeStatck {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0; i < 10; i++){
            stack.push(i);
        }

        System.out.println(stack.peek());
        stack.push(10);
        System.out.println(stack.pop());
        stack.push(11);


    }

    private static class Stack<T>{
        private final LinkedList<T> queue1 = new LinkedList<T>();
        private final LinkedList<T> queue2 = new LinkedList<T>();

        public synchronized T push(T t){
            Queue queueTemp =  queue1.isEmpty() ? (queue2.isEmpty() ? queue1 : queue2) : queue1;
            queueTemp.add(t);
            return t;
        }

        public synchronized T pop(){

            if(empty()){
                return null;
            }

            Queue<T> queueNoEmpty =  queue1.isEmpty() ? (queue2.isEmpty() ? queue1 : queue2) : queue1;

            if(queueNoEmpty.isEmpty()){
                return null;
            }

            Queue<T> queueEmpty = queue1.isEmpty() ? queue1 : queue2;

            T temp = queueNoEmpty.poll();

            T lastOne = null;

            while(temp != null){
                queueEmpty.add(temp);
                if(queueNoEmpty.size() == 1){
                    lastOne = queueNoEmpty.poll();
                    break;
                }
                temp = queueNoEmpty.poll();
            }

            return lastOne;
        }

        public synchronized T peek(){
            if(empty()){
                return null;
            }

            Queue<T> queueNoEmpty =  queue1.isEmpty() ? (queue2.isEmpty() ? queue1 : queue2) : queue1;

            if(queueNoEmpty.isEmpty()){
                return null;
            }

            Queue<T> queueEmpty = queue1.isEmpty() ? queue1 : queue2;

            T temp = queueNoEmpty.poll();

            T lastOne = null;

            while(temp != null){
                queueEmpty.add(temp);
                if(queueNoEmpty.size() == 1){
                    lastOne = queueNoEmpty.peek();
                }
                temp = queueNoEmpty.poll();
            }
            return lastOne;
        }

        public boolean empty(){
            return queue1.isEmpty() && queue2.isEmpty();
        }

    }
}
