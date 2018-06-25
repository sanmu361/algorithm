package com.sanmu.algorithm.数学;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-06-25 11:35
 **/
public class ThreeSum {

    public static void main(String[] args) {

    }

    private static String solution(String line) {
        // 在此处理单行数据
        String[] str = line.split(",");
        List<Integer> numsList = new ArrayList<Integer>();

        int count = 0;

        for(int i = 0 ; i < str.length; i++ ){
            numsList.add(Integer.parseInt(str[i]));
        }

        Collections.sort(numsList);

        int len = numsList.size();

        for (int i = 0; i < len - 2; i++){
            if (i > 0 && numsList.get(i - 1).equals(numsList.get(i)))
                continue;
            Integer a = numsList.get(i);
            int low = i + 1;
            int high = len - 1;

            while (low < high){
                Integer b = numsList.get(low);
                Integer c = numsList.get(high);

                if ((a + b + c) == 0){
                    count++;
                    while (low < len - 1 && numsList.get(low).equals(numsList.get(low + 1)))
                        low++;
                    while (high > 0 && numsList.get(high).equals(numsList.get(high - 1)))
                        high--;
                    low++;
                    high--;
                }else if ((a + b + c) > 0){
                    while (high > 0 && numsList.get(high).equals(numsList.get(high - 1)))
                        high--;
                    high--;
                }else{
                    while (low < len - 1 && numsList.get(low).equals(numsList.get(low + 1)))
                        low++;
                    low++;
                }
            }
        }
        return String.valueOf(count);
    }
}
