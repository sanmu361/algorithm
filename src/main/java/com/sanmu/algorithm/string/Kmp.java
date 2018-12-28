package com.sanmu.algorithm.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-05-22 12:15
 **/
public class Kmp {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int num = scanner.nextInt();
//        scanner.nextLine();
//        while(num-- > 0){
//            String p = scanner.nextLine();
//            String t = scanner.nextLine();
//
//            System.out.println(solution(t,p));
//        }

        String str[] = new String[]{"foo","bar"};
        System.out.println(findSubstring("barfoothefoobarman",str
                ));
    }

    public static String solution(String t,String p){

        int next[] = new int[p.length() + 1];

        for(int i = 0; i < p.length(); i++) {
            next[i] = 0;
        }

        for(int i = 1; i < p.length(); i++){
            int j = i;
            while(j > 0){
                j = next[j];
                if(p.charAt(i) == p.charAt(j)){
                    next[i + 1] = j + 1;
                    break;
                }
            }
        }
        int ans = 0;

        for(int i = 0,j = 0; i < t.length(); i ++){
            if(j < p.length() && t.charAt(i) == p.charAt(j)){
                j++;
            }else{
                while(j > 0){
                    j = next[j];
                    if(t.charAt(i) == p.charAt(j)){
                        j++;
                        break;
                    }
                }
            }

            if(j == p.length()){
                ans++;
            }
        }

        return String.valueOf(ans);
    }

    private static String solution(String line) {
        String[] str = line.split(" ");
        int next[] = new int[str[0].length()];

        for(int i = 0; i < str[0].length(); i++){
            next[i] = 0;
        }

        for(int i =1; i < str[0].length(); i++){
            int j = i;
            while(j > 0){
                j = next[i];
                if(str[0].charAt(i) == str[0].charAt(j)){
                    next[i + 1] = j + 1;
                    break;
                }
            }
        }

        for(int i = 0,j = 0; i < str[1].length(); i++){
            if(j < str[0].length() && str[1].charAt(i) == str[0].charAt(j)){
                j++;
            }else{
                while(j > 0){
                    j = next[j];
                    if(str[1].charAt(i) == str[0].charAt(j)){
                        j++;
                        break;
                    }
                }
            }
            if(j == str[0].length()){
                return "true";
            }
        }

        // 返回处理后的结果
        return "false";
    }

    public static int strStr(String haystack, String needle) {

        int[] next = new int[needle.length() + 1];


        for(int i = 0; i < next.length; i++){
            next[i] = 0;
        }

        for(int i = 1; i < needle.length(); i++){
            int j = i;
            while(j > 0){
                j = next[j];
                if(needle.charAt(i) == needle.charAt(j)){
                    next[i + 1] = j + 1;
                    break;
                }
            }
        }

        for(int i = 0, j = 0; i < haystack.length(); i++){
            if(j < needle.length() && haystack.charAt(i) == haystack.charAt(j)){
                j++;
            }else{
                while(j > 0){
                    j = next[j];
                    if(haystack.charAt(i) == needle.charAt(j)){
                        j++;
                        break;
                    }
                }
            }
            if(j == needle.length()){
                return i;
            }

        }

        return -1;

    }

    private static int kmp1(String t, String p){
        int next[] = new int[p.length() + 1];

        for(int i = 0; i < next.length; i++){
            next[i] = 0;
        }

        for(int i = 1; i < p.length(); i++){
            int j = i;
            while(j > 0){
                j = next[j];
                if(p.charAt(i) == p.charAt(j)){
                    next[i + 1] = j + 1;
                }
            }
        }

        int num = 0;

        for(int i = 0, j = 0; i < t.length(); i++){
            if(j < p.length() && t.charAt(i) == p.charAt(j)){
                j++;
            }else{
                while(j > 0){
                    j = next[j];
                    if(t.charAt(i) == p.charAt(j)){
                        j++;
                        break;
                    }
                }
            }

            if(j == p.length() - 1){
                num++;
            }
        }
        return num;
    }

    private static int kmp(String t ,String p){
        int next[] = new int[p.length() + 1];

        for(int i = 1; i < p.length(); i++){
            int j = i;
            while(j > 0){
                j = next[j];
                if(p.charAt(i) == p.charAt(j)){
                    next[i + 1] = j + 1;
                }
            }
        }

        int num = 0;

        for(int i = 0,j = 0; i < t.length(); i++){
            if(j < p.length() && t.charAt(i) == p.charAt(j)){
                j++;
            }else{
                while(j > 0){
                    j = next[j];

                    if(t.charAt(i) == p.charAt(j)){
                        j++;
                        break;
                    }
                }
            }
            if(j == p.length() - 1){
                num++;
            }
        }
        return num;
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if(words.length == 0) {
            return result;
        }
        //num represents the length of words array
        int num = words.length;
        //len represents the length of words[0]
        int len = words[0].length();
        //Create a hashMap whose key are Strings in words array and values are there appearance times in words array
        HashMap<String, Integer> hashMap = new HashMap<String,Integer>();
        for(int i = 0; i < num; i++) {
            if(hashMap.containsKey(words[i])) {
                hashMap.put(words[i], hashMap.get(words[i]) + 1);
            }else {
                hashMap.put(words[i], 1);
            }
        }
        for(int i = 0; i < len; i++) {
            //floating window[left, right - 1]
            HashMap<String, Integer> window = new HashMap<String,Integer>();
            int left = i;
            int right = i;
            while(right < s.length() - len + 1 && left < s.length() - len * num + 1) {
                String subStringRight = s.substring(right, right + len);
                if(!hashMap.containsKey(subStringRight)) {
                    right += len;
                    left = right;
                    window.clear();
                    continue;
                }
                if(!window.containsKey(subStringRight)) {
                    window.put(subStringRight, 1);
                }else {
                    window.put(subStringRight, window.get(subStringRight) + 1);
                }
                right += len;
                while(window.get(subStringRight) > hashMap.get(subStringRight)) {
                    String subStringLeft = s.substring(left, left + len);
                    window.put(subStringLeft, window.get(subStringLeft) - 1);
                    if(window.get(subStringLeft) == 0){
                        window.remove(subStringLeft);
                    }
                    left += len;
                }
                if(right - left == num * len) {
                    result.add(left);
                }
            }
        }
        return result;

    }
}
