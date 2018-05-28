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
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        while(num-- > 0){
            String p = scanner.nextLine();
            String t = scanner.nextLine();

            System.out.println(solution(t,p));
        }


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
}
