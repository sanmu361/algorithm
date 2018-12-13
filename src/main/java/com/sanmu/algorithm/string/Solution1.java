package com.sanmu.algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-11-30 11:07
 **/
public class Solution1 {
    public static String minWindow(String s, String t) {
        if(s == null || s.length() == 0){
            return "";
        }
        if(t == null || t.length() == 0){
            return "";
        }

        List<Integer> list = new ArrayList<Integer>();
        ArrayList<Character> set = new ArrayList<Character>();
        for(int i = 0; i < t.length(); i++){
            set.add(t.charAt(i));
        }

        for(int i = 0; i < s.length();i++){
            if(set.contains(Character.valueOf(s.charAt(i)))){
                list.add(i);
            }
        }

        int dp[] = new int[list.size()];

        boolean flag = false;
        int index = 0;

        for(int i = 0; i < list.size(); i++){
            List<Character> temp = (List<Character>)set.clone();
            int j = i;
            for(; j < list.size(); j++){
                temp.remove(Character.valueOf(s.charAt(list.get(j))));
                if(temp.size() == 0){
                    dp[i] = list.get(j) - list.get(i) + 1;
                    if(i != 0){
                        if(dp[i - 1] < dp[i]){
                            dp[i] = dp[i - 1];
                        }else{
                            index = list.get(i);
                        }
                    }else{
                        index = list.get(i);
                    }

                    flag = true;
                    break;
                }
            }

            if(j == list.size()){
                if(i != 0){
                    dp[i] = dp[i - 1];
                }else{
                    dp[i] = s.length();
                }
            }
        }

        if(list.size() > 0 && flag){
            return s.substring(index,dp[list.size() - 1] + index);
        }

        return "";
    }

    public static String minWindow1(String S, String T) {
        int[] srcHash = new int[255];
        // 记录目标字符串每个字母出现次数
        for(int i = 0; i < T.length(); i++){
            srcHash[T.charAt(i)]++;
        }
        int start = 0,i= 0;
        // 用于记录窗口内每个字母出现次数
        int[] destHash = new int[255];
        int found = 0;
        int begin = -1, end = S.length(), minLength = S.length();
        for(start = i = 0; i < S.length(); i++){
            // 每来一个字符给它的出现次数加1
            destHash[S.charAt(i)]++;
            // 如果加1后这个字符的数量不超过目标串中该字符的数量，则找到了一个匹配字符
            if(destHash[S.charAt(i)] <= srcHash[S.charAt(i)]) found++;
            // 如果找到的匹配字符数等于目标串长度，说明找到了一个符合要求的子串
            if(found == T.length()){
                // 将开头没用的都跳过，没用是指该字符出现次数超过了目标串中出现的次数，并把它们出现次数都减1
                while(start < i && destHash[S.charAt(start)] > srcHash[S.charAt(start)]){
                    destHash[S.charAt(start)]--;
                    start++;
                }
                // 这时候start指向该子串开头的字母，判断该子串长度
                if(i - start < minLength){
                    minLength = i - start;
                    begin = start;
                    end = i;
                }
                // 把开头的这个匹配字符跳过，并将匹配字符数减1
                destHash[S.charAt(start)]--;
                found--;
                // 子串起始位置加1，我们开始看下一个子串了
                start++;
            }
        }
        // 如果begin没有修改过，返回空
        return begin == -1 ? "" : S.substring(begin,end + 1);
    }

    public static void main(String[] args) {
        System.out.println(minWindow1("ADOBECODEBANC","ABC"));
    }
}
