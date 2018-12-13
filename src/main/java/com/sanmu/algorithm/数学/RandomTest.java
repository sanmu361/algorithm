package com.sanmu.algorithm.数学;

import java.util.Random;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-12-04 20:09
 **/
public class RandomTest {


    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            int[] temp = getRandom(10,3);
            System.out.println(temp[0] + " " + temp[1] + " " + temp[2]);
        }

    }

    public static int[] getRandom(int sum,int count){
        Random random = new Random();
        int result[] = new int[count];
        int temp = sum / count;
        for(int i = 0; i < count - 1; i++){
            result[i] = random.nextInt(temp + 1);
            sum -= result[i];
        }
        result[count - 1] = sum;
        return result;
    }
}
