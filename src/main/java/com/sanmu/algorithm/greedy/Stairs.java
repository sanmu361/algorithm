package com.sanmu.algorithm.greedy;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-05-28 14:34
 **/
public class Stairs {

    public static void main(String[] args) {
        System.out.println(solution("10"));
    }

    private static String solution(String line){
        return String.valueOf(count(Integer.parseInt(line)));
    }

    private static int count(int count){
        if(count == 1){
            return 1;
        }else if(count == 2){
            return 2;
        }else if(count == 0){
            return 0;
        }else{
            return count(count - 1) + count(count - 2);
        }
    }
}
