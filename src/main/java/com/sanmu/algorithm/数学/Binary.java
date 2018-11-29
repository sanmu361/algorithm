package com.sanmu.algorithm.数学;

import org.apache.commons.lang3.StringUtils;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-11-09 10:16
 **/
public class Binary {

    public static void main(String[] args) {

     String temp = binaryToDecimal(2015);

     int plusOneCount = -1;
        int twoMuilCount = temp.length() - 1;
     for(int i = 0; i < temp.length(); i++ ){
         if('1' == temp.charAt(i)){
             plusOneCount++;
         }
     }
     System.out.println(plusOneCount + twoMuilCount);

    }

    public static String binaryToDecimal(long n){
        StringBuilder result = new StringBuilder();
        while(n > 0){
            result.append(n & 1);
            n >>>= 1;
        }

        return result.reverse().toString();
    }

    public static String binaryToDecimal1(long n){
        StringBuilder result = new StringBuilder();

        while(n > 0){
            result.append(n % 2);
            n /= 2;
        }
        return result.reverse().toString();


    }

}
