package com.sanmu.algorithm.bigNumbers;

import java.util.Scanner;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-05-23 11:08
 **/
public class Exponentiation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        while(num-- > 0){
            String line = scanner.nextLine();

            System.out.println(solution(line));
        }
    }

    private static String solution(String line){
        String[] numStrs = line.split(" ");
        String[] numStr = new String[2];

        for(int i = 0,j = 0; i < numStrs.length && j != 2; i++){
            if(!"".equals(numStrs[i])){
                  numStr[j++] = numStrs[i];
            }
        }

        StringBuilder stringBuilder = new StringBuilder(numStr[0]);
       while(stringBuilder.charAt(0) == '0'){
           stringBuilder = stringBuilder.replace(0,1,"");
        }

        while(stringBuilder.charAt(stringBuilder.length() - 1) == '0'){
           stringBuilder = stringBuilder.replace(stringBuilder.length() - 1,stringBuilder.length() ,"");
        }

        int index = stringBuilder.indexOf(".");

        if(index != -1){
            stringBuilder = stringBuilder.replace(index,index + 1,"");
            index = stringBuilder.length() - index;
        }


        int n = Integer.parseInt(numStr[1]);

        index = index * n;

        String a = stringBuilder.toString();
        String c = stringBuilder.toString();
        for(int i = 1; i < n; i++){
            c = BigNumMultipy(c,a);
        }

        stringBuilder = new StringBuilder(c);

        while(stringBuilder.charAt(0) == '0'){
            stringBuilder = stringBuilder.replace(0,1,"");
        }

        while(stringBuilder.charAt(stringBuilder.length() - 1) == '0'){
            stringBuilder = stringBuilder.replace(stringBuilder.length() - 1,stringBuilder.length() ,"");
        }

        stringBuilder.insert(stringBuilder.length() - index,".");

        return stringBuilder.toString();
    }



    private static String BigNumMultipy(String a,String b){
        int len1 = a.length();
        int len2 = b.length();

        int[] a1 = new int[len1];
        int[] b1 = new int[len2];

        for(int i = len1 - 1,j = 0; i >= 0; i--){
            a1[j++] = a.charAt(i) - '0';
        }

        for(int i = len2 - 1,j = 0; i >= 0; i--){
            b1[j++] = b.charAt(i) - '0';
        }

        int[] result = new int[len1 + len2];

        for(int k = 0; k < len1 + len2; k++){
            result[k] = 0;
        }

        int i,j;

        for(i = 0; i < len1; i++){
            for(j = 0; j < len2; j++){
                result[i + j] += a1[i] * b1[j];
            }
        }

        for(int k = 0; k < len1 + len2 - 1; k++){
            result[k + 1] += result[k] / 10;
            result[k] %= 10;
        }

        StringBuilder resultStr = new StringBuilder();

        for(int k = 0; k < len1 + len2; k++){
            resultStr.insert(0,String.valueOf(result[k]));
        }

        return resultStr.toString();
    }


}
