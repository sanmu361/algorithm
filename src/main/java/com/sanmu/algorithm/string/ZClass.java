package com.sanmu.algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-10-26 16:43
 **/
public class ZClass {

    public static void main(String[] args) {
        System.out.println(myAtoi("  -42"));
    }

    public static String covert(String s, int numRows){
       if(numRows == 1){
           return  s;
       }

       boolean downUp = false;
       int curRow = 0;

       List<StringBuilder> tempList = new ArrayList<>();

       for(int i = 0; i < tempList.size(); i++){
           tempList.add(new StringBuilder());
       }

       for(int i = 0; i < s.length(); i++){
           tempList.get(curRow).append(s.charAt(i));
           if(curRow == 0 || curRow == numRows - 1){
               downUp = !downUp;
           }
           if(downUp){
               curRow++;
           }else{
               curRow--;
           }
       }
       StringBuilder result = new StringBuilder();
       for(int i = 0;i < numRows; i++){
           result.append(tempList.get(i));
       }
       return result.toString();
    }

    public static int myAtoi(String str) {


        if(str.length() == 0){
            return 0;
        }


        int index = -1;
        int end = 0;


        for(; end < str.length(); end++){
            System.out.println(str.charAt(end));
            if(str.charAt(end) <= '9' && str.charAt(end) >= '0'){
                if(index < 0){
                    index = end;
                }
            }else{
                if(index >= 0){
                    break;
                }
            }
        }

        int count = 0;
        for(int i = 0; i < index; i++){

            if(count <= 0 && (str.charAt(i) == '-' || str.charAt(i) == '+')){
                count++;
            }
            if(str.charAt(i) != ' ' ){
                return 0;
            }
        }
        if(index < 0 ){
            return 0;
        }

        String numStr = str.substring(index,end);

        if(numStr.length() == 0){
            return 0;
        }

        try{
            return Integer.parseInt(numStr.toString());
        }catch(Exception e){
            if(numStr.charAt(0) == '-'){
                return -2147483648;
            }else{
                return 2147483647;
            }
        }

    }

    public static boolean isPalindrome(int x) {
        StringBuilder num = new StringBuilder(String.valueOf(x));

        StringBuilder num1 = num.reverse();

        num = new StringBuilder(String.valueOf(x));

        for(int i = 0; i < num.length(); i++){
            if(num.charAt(i) != num1.charAt(i) ){
                return false;
            }
        }

        return true;
    }

}
