package com.sanmu.algorithm.string;

import com.google.gson.Gson;

/**
 * ${DESCRIPTION}
 *
 * @author yansen
 * @create 2018-12-13 10:25
 **/
public class Solution2 {

    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {

        if(s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()){
            return false;
        }

        boolean [][] f = new boolean[s1.length() + 1][s2.length() + 1];

        f[0][0] = true;

        for(int i = 0; i < s1.length() + 1; i++){
            for(int j = 0; j < s2.length() + 1; j++){
                if(j > 0){
                    f[i][j] = f[i][j - 1] && (s3.charAt(i + j - 1) == s2.charAt(j - 1));
                }
                if(i > 0){
                    f[i][j] = f[i][j] || ( f[i-1][j]&&(s3.charAt(i+j-1) == s1.charAt(i-1)));
                }
            }
        }
        Gson gson = new Gson();

        System.out.println(gson.toJson(f));

        return f[s1.length()][s2.length()];
    }

}
