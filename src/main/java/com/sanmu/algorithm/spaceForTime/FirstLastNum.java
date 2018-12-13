package com.sanmu.algorithm.spaceForTime;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-05-21 20:11
 **/
public class FirstLastNum {

    public static void main(String[] args) {
        System.out.println(solution("-1,-10,0"));
    }

    private static String solution(String line){
        String strs[] = line.split(",");

        int max = 2;
        for(String str : strs){
            int a = Integer.parseInt(str);
            max = (a + 2) > max ? a + 2 : max;
        }
        int numx[] = new int[max];
        for(String str : strs){
            int a = Integer.parseInt(str);
            if(a >= 0){
                numx[a] = 1;
            }
        }

        for(int i = 1; i < numx.length; i++ ){
            if(numx[i - 1] == 1 && numx[i] == 0){
                return String.valueOf(i);
            }
        }
        return String.valueOf(1);

    }

    private static String solution1(String line) {
        TreeSet<Integer> sets = new TreeSet<Integer>();
        String[] datas = line.split(",");
        for (String data : datas) {
            sets.add(Integer.valueOf(data));
        }
        int miss = 1;
        Iterator<Integer> iterator = sets.iterator();
        while (iterator.hasNext()) {
            int current = iterator.next();
            if (current > 0 && current > miss) {
                return String.valueOf(miss);
            } else if (current > 0) {
                miss++;
            }
        }
        return String.valueOf(miss);
    }

}
