package com.sanmu.algorithm.LinkedList;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-10-25 10:30
 **/
public class LIS {

    public static void main(String[] args) {
        int array[] = new int[]{5,6,7,1,2,8};

        System.out.println(solution(array));
    }

    private static int solution(int array[]){
        int longest[] = new int[array.length];

        for(int i = 0; i < array.length; i++){
            longest[i] = 1;
        }

        for(int i = 0; i < array.length; i++){
            for(int j = 1; j < array.length; j++){
                if(array[j] > array[i]){
                    longest[j] = Math.max(longest[j],longest[i] + 1);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < longest.length; i++){
            if(max < longest[i]){
                max = longest[i];
            }
        }
        return max;
    }
}
