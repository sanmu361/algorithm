package com.sanmu.algorithm.bigNumbers;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-07-03 12:05
 **/
public class AddNumbers {

    public static void main(String[] args) {
        System.out.println(solution("7625022925148127196027859399571498914361","790786706794530"));
                                    //"11111111100"
    }

    private static String solution(String num1, String num2) {
        // 在此处理单行数据

        StringBuilder numbers1 = new StringBuilder(num1);
        numbers1 = numbers1.reverse();
        StringBuilder numbers2 = new StringBuilder(num2);
        numbers2 = numbers2.reverse();

        StringBuilder result = new StringBuilder();

        int temp = 0;
        int jinwei = 0;

        int i = 0;

        for(; i < numbers1.length() && i < numbers2.length(); i++){
            temp = numbers1.charAt(i) - '0' + numbers2.charAt(i) - '0';
            temp += jinwei;
            jinwei = temp / 10;
            result.append(temp % 10);
        }

        for(;i < numbers1.length();i++){
            temp = numbers1.charAt(i) - '0' + jinwei;
            jinwei = temp / 10;
            result.append(temp % 10);
        }

        for(;i < numbers2.length();i++){
            temp = numbers2.charAt(i) - '0' + jinwei;
            jinwei = temp / 10;
            result.append(temp % 10);
        }
        if(jinwei != 0){
            result.append(jinwei);
        }

        // 返回处理后的结果
        return result.reverse().toString();
    }
}
