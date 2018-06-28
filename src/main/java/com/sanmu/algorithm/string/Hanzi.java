package com.sanmu.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-06-27 15:18
 **/
public class Hanzi {
    public static void main(String[] args) {
        System.out.println(solution("38497309937"));
    }


    private static String solution(String line){
        StringBuilder stringBuilder = new StringBuilder();

        Map<Character,String> map = new HashMap<Character,String>(){{
            put('1',"壹");
            put('2',"贰");
            put('3',"叁");
            put('4',"肆");
            put('5',"伍");
            put('6',"陆");
            put('7',"柒");
            put('8',"捌");
            put('9',"玖");
            put('0',"零");
        }};

        Map<Integer,String> map1 = new HashMap<Integer, String>(){{
            put(0,"");
            put(1,"拾");
            put(2,"佰");
            put(3,"仟");
            put(4,"万");
            put(5,"拾");
            put(6,"佰");
            put(7,"仟");
            put(8,"亿");
            put(9,"拾");
            put(10,"仟");
        }};


        boolean flag = true;
        boolean flag1 = true;
        for(int i = line.length() - 1,j = 0; i >= 0; ){
            int k = 0;
            stringBuilder.insert(0,map1.get(j));
            for(;k < 4 && i - k >= 0; k++){
                j++;
                if('0' == line.charAt(i - k) && flag) {
                    continue;
                }

                if('0' == line.charAt(i - k)) {
                    if(flag1){
                        stringBuilder.insert(0,map.get(line.charAt(i - k)));
                    }

                    flag1 = false;
                }else{
                    stringBuilder.insert(0,map1.get(k)).insert(0,map.get(line.charAt(i - k)));
                    flag1 = true;
                    flag = false;
                }
            }
            flag = true;

            i = i - k;
        }
        if(stringBuilder.length() == 0){
            stringBuilder.append("零");
        }

        stringBuilder.append("元整");

        return stringBuilder.toString();
    }
}
