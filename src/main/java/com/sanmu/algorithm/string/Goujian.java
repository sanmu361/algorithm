package com.sanmu.algorithm.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-06-19 10:20
 **/
public class Goujian {

    public static void main(String[] args) {
        System.out.println(solution("mioj quiejwrcom"));
    }

    private static String solution(String line) {
        // 在此处理单行数据

        String [] strs = line.split(" ");

        List<Character> set = new ArrayList<Character>();

        for(int i = 0; i < strs[1].length(); i++){
            set.add(strs[1].charAt(i));
        }

        String flag = "true";

        for(int i = 0; i < strs[0].length(); i++){
            if(set.contains(strs[0].charAt(i))){
                set.remove(new Character(strs[0].charAt(i)));
            }else{
                flag = "false";
                break;
            }
        }

        // 返回处理后的结果
        return flag;
    }

}
