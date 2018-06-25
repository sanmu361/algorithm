package com.sanmu.algorithm.string;

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

        System.out.println(solution("mi zhizhqpoem"));
    }

    public static String solution(String t,String p){

        int next[] = new int[p.length()];

        for(int i = 0; i < p.length(); i++) {
            next[i] = 0;
        }

        for(int i = 1; i < p.length(); i++){
            int j = i;
            while(j > i){
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
            while(j > i){
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
}
