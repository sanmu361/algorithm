package com.sanmu.algorithm.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-09-18 9:54
 **/
public class Median {

    public static void main(String[] args) {

        int array[] = new int[9];

        for(int i = 1 ; i < 10; i++){
            array[i - 1] = i;
        }
        System.out.println(median(array));


    }

    private static int median(int[] array){

        assert(array != null && array.length > 0);

        int length = (array.length + 1) / 2;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(length,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for(int i = 0; i < length; i ++){
            maxHeap.offer(array[i]);
        }

        for(int i = length; i < array.length; i++){
            if(array[i] > maxHeap.peek()){
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }

        if(!maxHeap.isEmpty()){
            return maxHeap.poll();
        }
        return -1;
    }
}
