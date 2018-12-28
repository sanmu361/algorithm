package com.sanmu.algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-12-27 10:38
 **/
public class YanzhengHuiwen {

    public static void main(String[] args) {
        isPalindrome("OP");
    }

    public static boolean isPalindrome(String s) {
        List<Character> list = new ArrayList<Character>();

        s = s.toLowerCase();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) <= 'z' && s.charAt(i) >= 'a' ){
                list.add(s.charAt(i));
            }
        }

        for(int i = 0, j = list.size() - 1; i <= j; i++,j--){
            if(!list.get(i).equals(list.get(j))){
                return false;
            }
        }

        return true;
    }

}
