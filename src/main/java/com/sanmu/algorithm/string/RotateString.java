package com.sanmu.algorithm.string;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-12-20 12:07
 **/
public class RotateString {

    public static void main(String[] args) {

        String a = "abcdef";
        System.out.println(rotate(a,2));
    }

    private static String rotate(String value, int num){
        int n = num % value.length();

        StringBuilder v1 = new StringBuilder(value.substring(0,n));
        StringBuilder v2 = new StringBuilder(value.substring(n,value.length()));

        v1 = v1.reverse();
        v2 = v2.reverse();

        v1.append(v2);

        return v1.reverse().toString();
    }
}
